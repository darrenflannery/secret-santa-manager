package com.aylien.secretsantamanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aylien.secretsantamanager.domain.TeamMember;
import com.aylien.secretsantamanager.domain.TeamMemberHistoryRecord;
import com.aylien.secretsantamanager.repository.TeamMemberRepository;

@Service("secretSantaService")
public class SecretSantaServiceImpl implements SecretSantaService{

	@Autowired
	private TeamMemberRepository repo;

	public List<String> createList(){

		List<TeamMember> team = repo.findAll();

		int mainRetry = 0;
		boolean allMatched=false;

		//I set the amount of retries to avoid an infinite loop
		//In some cases, it will not be possible to create list. 
		//This method allows 100 attempts to get a list that follows all the rules
		while(mainRetry<100 && !allMatched) {
			
			List<Integer> excludeList = new ArrayList<Integer>();
			List<Integer> alreadyAssigned = new ArrayList<Integer>();

			for(int i=0;i<team.size();i++) {

				//create list of id's that cannot be a recipient
				//1. Include people who have been a recipient in the last two years
				excludeList.addAll(getListOfPreviousRecipients(team.get(i),2));
				//2. Include themselves
				excludeList.add(team.get(i).getId());
				//3. Add already assigned
				excludeList.addAll(alreadyAssigned);
				
				//Allowing n(team size) tries to get a random recipient not in the exclude list
				int retry =0;
				int maxRetries = team.size();
				
				int potentialRecipient;
				//generate a random id that is not in the exclude list
				do {
					potentialRecipient = getRandomElement(createListFromIds());
					retry++;
				}while(excludeList.contains(potentialRecipient) && retry<maxRetries);

				
				if(retry>=maxRetries) {
					mainRetry++;
					break;
				}
				
				else {					
					//add this newly assigned user to exclude list so he/she will not be added again
					alreadyAssigned.add(potentialRecipient);
					excludeList.clear();
					team.get(i).setRecipientId(potentialRecipient);
					repo.save(team.get(i));

					//check if all matched
					if(i>=team.size()-1 && checkIfAllMatched(team)) {allMatched=true;}
				}
			}
		}
		
		if(allMatched==true) {
			return makeReadable(team);
		}
		else{
			//do some error handling
			team = clearAllRecipientIds(team);
			return makeReadable(null);
		}
	}
	
	private List<String> makeReadable(List<TeamMember> team) {
		List<String> result = new ArrayList<String>();
		if(team==null) {
			result.add("Impossible Task");
			return result;
		}
		else {
		for(int i=0;i<team.size();i++) {
			TeamMember santa = team.get(i);
			TeamMember recipient = repo.getById(team.get(i).getRecipientId());
			String s = santa.getFirstName() +  " "  + santa.getLastName() + " gets: " + recipient.getFirstName() + " " + recipient.getLastName(); 
			result.add(s);
		}
		return result;
		}
	}

	private List<Integer> createListFromIds(){
		List<Integer> field1List = (repo.findAll())
				.stream()
				.map(TeamMember -> TeamMember.getId())
				.collect(Collectors.toList());
		return field1List;
	}

	private List<Integer> getListOfPreviousRecipients(TeamMember teamMember, int years){
		//TODO:
		//only go back n years from current year
		List <TeamMemberHistoryRecord> r = teamMember.getHistoryRecords();
		List<Integer> list = new ArrayList<Integer>();
		if(r!=null) {
			for(int i=0; i<r.size();i++) {
				list.add(r.get(i).getRecipientId());
			}
		}
		return list;
	}
	
	private List<TeamMember> clearAllRecipientIds(List<TeamMember> team) {
		for(int i=0;i<team.size();i++) {
			team.get(i).setRecipientId(null);
		}
		return team;
	}
	
	private boolean checkIfAllMatched(List<TeamMember> team) {
		boolean allMatched = true;
		for(int i=0;i<team.size();i++) {
			if(team.get(i).getRecipientId()==null) {
				allMatched = false;
			}
		}
		return allMatched;
	}

	private int getRandomElement(List<Integer> list){
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}
}