package com.telusko.JobApp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telusko.JobApp.model.JobPost;
import com.telusko.JobApp.service.JobService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobController {

	@Autowired
	private JobService service;

	// ************************************************************************

	@RequestMapping({"/","/home"})
	public String home() {
		return "home";
	}

	//*************************************************************************

	@RequestMapping("/apply")
	public String apply() {
		return "apply";
	}

	//*************************************************************************
	@RequestMapping("/Contact")
	public String Contact() {
		return "Contact";
	}
	// ************************************************************************

	@RequestMapping("/addjob")
	public String addJob() {
		return "addjob";
	}

	// ************************************************************************

	// controller method for getting all job posts
	@GetMapping("/viewalljobs")
	public String viewJobs(Model model) {

		List<JobPost> jobPosts = service.returnAllJobPosts();
		model.addAttribute("jobPosts", jobPosts);
		return "viewalljobs";
	}
	
	// ************************************************************************

//	@RequestMapping("/applyjob")
//	public ModelAndView applyjob(int postId,String postProfile,String postDesc,Integer reqExperience,List<String> postTechStack,ModelAndView mv){
//		System.out.println(postId);
//		System.out.println(postProfile);
//		System.out.println(postDesc);
//		System.out.println(reqExperience);
//		System.out.println(postTechStack);
//
//        return mv;
//	}

	@RequestMapping("/applyjob")
	public ModelAndView applyjob(String fullName,String contact, String email,int exp, MultipartFile resume, ModelAndView mv){
		System.out.println(fullName);
		System.out.println(contact);
		System.out.println(email);
		System.out.println("Work experience is : " + exp +"years");
		return mv;
	}

	// ************************************************************************


	@PostMapping("/handleForm")
	public String handleAddJobForm(JobPost jobPost,Model model) {
		model.addAttribute("jobPost", jobPost);
		service.addJobPost(jobPost);
		//System.out.println(jobPost);
		  return "success";
		
	}
	
	
}
