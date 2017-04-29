package com.swe.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import java.util.List;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.swe.entity.Game;
import com.swe.entity.User;
import com.swe.model.AddGameModel;
import com.swe.model.AddUserModel;
//import com.swe.repository.UserRepo;
//import com.swe.repository.UserService;


@Controller
//@SessionAttributes("SequenceID")
public class Services {
	
	//تحضير جميع فانكشنز الداتا بيز + الشغل على كلاس اليوزر بترتيب اتربيوته
	//@Autowired
	//private UserRepo Repo;
	
	//@Autowired
	//private UserService Search;
	
	//@Autowired 
	//private HttpSession session;
	
/*
	
	@RequestMapping("/Registration")
	public String Register(@RequestParam("Name") String Name, @RequestParam("Password") String Password, @RequestParam("ID") String ID, @RequestParam("Type") String Type){
		AddUserModel User = new AddUserModel();
		User.addUser_DB(Name, Password, ID, Type);
		return "Done";
	}

*/
	

	
	
	
	
	
	
	
	
	
	@GetMapping("/AddUser")
	public String ShowAddUserForm(Model model){
		model.addAttribute("User", new User());
		return "AddUser";
	}
	
	
	@PostMapping("/AddUser")
    public String AddUser(Model model, @ModelAttribute User user){
		
		model.addAttribute("User", new User());
		System.out.println(user.getName());
		System.out.println(user.getID());
		System.out.println(user.getPassword());
		System.out.println(user.getType());
		//Repo.save(user);
		AddUserModel User = new AddUserModel();
		User.addUser_DB(user.getName(), user.getPassword(), user.getID(), user.getType());
		return "index";
		
	}
	
	@GetMapping("/AddGame")
	public String ShowAddGameForm(Model model){
		model.addAttribute("Game", new User());
		return "AddGame";
	}
	
	
	@PostMapping("/AddGame")
    public String AddGame(Model model, @ModelAttribute Game game){
		
		model.addAttribute("Game", new User());
		System.out.println(game.getID());
		System.out.println(game.getName());
		System.out.println(game.getType());
		//Repo.save(game);
		AddGameModel Game = new AddGameModel();
		Game.addGame_DB(game.getName(), game.getID(), game.getType());
		return "UserHome";
		
	}
	
	
	
	
	@GetMapping("/CheckUser")
	public String showUserLoginForm(Model model){
		model.addAttribute("User",new User());
		return "UserLogin";
	}
	
	
	@PostMapping("/CheckUser")
	public String CheckUser(ModelMap model,@ModelAttribute User user) throws SQLException{
		model.addAttribute("User",new User());
		ResultSet Result = null;
		AddUserModel Model = new AddUserModel();
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		
		Result = Model.Result(user.getName(), user.getPassword());
		
		if(Result.next()){
			System.out.println("Hello");
			return "UserHome";
		}
		
		else{
			System.out.println("Invalid UserName Or Password");
			return "index";
		}
		
		
		//List<User> CheckUser = Search.GetAllUser();
		//System.out.println("Number Of Check Records = "+CheckUser.size());
		//System.out.println(CheckUser.get(0).getName());
		//System.out.println(CheckUser.get(0).getPassword());
		//System.out.println(CheckUser.get(0).getID());
		//System.out.println(CheckUser.get(0).getType());
		
		/*for(int I=0;I<CheckUser.size();I++){
		if(CheckUser.get(0).getName()==user.getName()&&CheckUser.get(0).getPassword()==user.getPassword()){
			System.out.println("Hello");
			//session.setAttribute("SequenceID",CheckUser.get(0).getSequenceID());
			return "UserHome";
		}
		
		else{
			System.out.println("Invalid UserName Or Password");
			return "index";
		}
	}*/
		
		
	}
	
	@RequestMapping(value="/search1", method = RequestMethod.GET)
	public String index1(){
		return "start";
	}
	@RequestMapping("/search2")
	public ModelAndView viewResult
	(@RequestParam("num1") String num1,
			 Model model
			){
		 AddGameModel lista =new AddGameModel();
		 ArrayList<String> o=new ArrayList<String>();
		 o=lista.findrecords();
				ModelAndView mv = new ModelAndView();
				mv.setViewName("resultsearch");
				if((num1.equals("Games"))||(num1.equals("GAMES"))||(num1.equals("games"))){
					
				mv.addObject("result",  num1+" is found" );
				mv.addObject("list", o+"   " );
				
				return mv;
				}
				
				else
				{
					mv.addObject("result",o );
					mv.addObject("list", o );
					
					return mv;
					
				}
			
				
			}
	@RequestMapping("/search3")
	public ModelAndView viewResult1
	(@RequestParam("game") String game,
	
	 Model model
	){
		
		ModelAndView mv = new ModelAndView();
		
		if(game.equals("math")){
			
			mv.setViewName("math");
			
			return mv;
		}
		else if(game.equals("general_information"))
		{
       mv.setViewName("ginf");
			
			return mv;
			
		}
		else if((game.equals("G3"))||(game.equals("G4")))
		{
			mv.setViewName("resultpage");
			mv.addObject("result",  game+" isn't created" );
			return mv;
		}
		else
		{
			mv.setViewName("resultpage");
			mv.addObject("result",  game+" isn't found" );
			return mv;
		}
		
	}
	
//*******************************************************************	
/*	@RequestMapping(value="/math", method = RequestMethod.GET)
	public String index11(){
		return "math";
	}*/
	
	@RequestMapping("/result1")
	public ModelAndView viewResult
	(@RequestParam("num1") int num1,
	
	 Model model
	){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultpage");
		if(num1 == 6){
		mv.addObject("result",  num1+" is correct" );
		return mv;}
		else if((num1 == 10) || (num1 == 4))
		{
			mv.addObject("result",num1+ " is faild" );
			return mv;
			
		}
		else
		{
			mv.addObject("result", num1+" number invalid" );
			return mv;
		}
	}
//***********************************************************************	
	
	
	@RequestMapping("/result")
	public ModelAndView viewResult
	(@RequestParam("num1") boolean num1,
	
	 Model model
	){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result_of_ginf");
		if(num1 == true){
			mv.addObject("result",  "YES, the man of war and peace is Mohamed Anower Elsadat" );
			return mv;}
		else 
		{
			mv.addObject("result", "NO,the result which is correct that the man of war and peace is Mohamed Anower Elsadat" );
			return mv;
		}
		/*else
		{
			mv.addObject("result", "your answer invalid please enter true or false" );
			return mv;
			
		}*/
	}
	

}
