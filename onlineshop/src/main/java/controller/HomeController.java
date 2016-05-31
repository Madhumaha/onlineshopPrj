package controller;

import DAO.ProductDao;
import DAO.ProductDaoImpl;
import Model.FileUpload;
import Model.Product;
import Model.User;
import service.ProductService;
import service.UserService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;




@Controller
public class HomeController {

	@Autowired
	 ProductService pservice;
	@Autowired
	 UserService uservice;
	 String fpath="";
	FileUpload fd=new FileUpload();
	public HomeController() {
		
	}


	String s=null;
	
	@RequestMapping(value = { "/","/welcome**" }, method = RequestMethod.GET)
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/admin/home")
	public String home1()
	{
		return "home";
	}
	
	/*@RequestMapping("/Product")
	public String listproducts(Model model) {
		
		
		
		 
		 model.addAttribute("employees", pservice.getAll());
			
			return "product";
		  
		 }*/
	
	@RequestMapping("/admin/addprod")
		 public ModelAndView getForm(@ModelAttribute("p") Product p) {
	  return new ModelAndView("addproduct");
	 }
	
	@RequestMapping("/Product")
	//@RequestMapping("/Product,/addProduct")
	public String product(@RequestParam(value="name") String name)
	{
		s=name;
	
		return "userproduct";
	}
	
	@RequestMapping("/admin/Product1")
	//@RequestMapping("/Product,/addProduct")
	public String adminproduct()
	{
		
	
		return "product";
	}
	
	
	@RequestMapping("/admin/p")
	public @ResponseBody String getadminValues()
	{	
		System.out.println("all product page");
		List<Product> plist=new ArrayList<Product>();
		plist=pservice.getAll();
		
		Gson gson=new Gson();
		String result= gson.toJson(plist);
		return result;
	}
	
	
	@RequestMapping("/p1")
	public @ResponseBody String getValues()
	{	List<Product> plist=new ArrayList<Product>();
		
		if((s.equals("1"))||(s.equals("2"))||(s.equals("3")))
		{
			 System.out.println(s);
			Product p=pservice.getRowById(1);
			plist.add(p);
		}
		if(s.equals("all"))
		{
		plist=pservice.getAll();
		}
		Gson gson=new Gson();
		String result= gson.toJson(plist);
		return result;
		 
		/*if((s.equals("img1"))||(s.equals("img2"))||(s.equals("img3")))
			plist=pdao.getproduct(s);
		if((s.equals("img4")))		
		plist = pdao.getAllproduct();
		Gson gson=new Gson();
		String result= gson.toJson(plist);
		return result;*/
	
	}
	
	@ModelAttribute("prd")//This refers to command name which we gave 
	public Product create()
	{
	System.out.println("inside modelattribute");
	return new Product();//creating a model object
	}
	@RequestMapping(value={"/admin/addProduct"},method=RequestMethod.POST)
	public ModelAndView adding(@Valid @ModelAttribute("p") Product p,BindingResult result,HttpServletRequest req, Model model)
	{

		if (result.hasErrors()) {
            return new ModelAndView("addproduct");
        }
		List<Product> pDetailList=pservice.getAll();

        for (int i=0; i< pDetailList.size(); i++) {

            if(p.getproductname().equals(pDetailList.get(i).getproductname())) {
                model.addAttribute("pnameMsg", "Productname already exists");
System.out.println("pnameMsg");
                return new ModelAndView("addproduct");
            }
            if(p.getId()==(pDetailList.get(i).getId())) {
                model.addAttribute("idMsg", "Id already exists");

                return new ModelAndView("addproduct");
            }
        }
        String filename=null;
        int res=0;
        ServletContext context=req.getServletContext();
        String path=context.getRealPath("./resources/"+p.getId()+".jpg");
        System.out.println("Path= "+path);
        System.out.println("File Name="+p.getImage().getOriginalFilename());
        File f=new File(path);
        if(!p.getImage().isEmpty())
        {
        	try
        	{
        		byte[] bytes=p.getImage().getBytes();
        		BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
        		bs.write(bytes);
        		bs.close();
        		System.out.println("Image uploaded");
        		pservice.create(p);//calls service method
        		System.out.println("Product added");
        	}
        	catch(Exception ex)
        	{
        		System.out.println(ex.getMessage());
        	}
        }
		
		
/*plist=pservice.getAll();
Gson gson=new Gson();
String result= gson.toJson(plist);
return result;*/
	return new ModelAndView("redirect:/admin/Product1");
	}
	
	@RequestMapping("/upload")
	public ModelAndView upload(
			@RequestParam(value = "usr", required = false, defaultValue = "World") String usr, 
			@RequestParam(value = "pwd", required = false, defaultValue = "") String pwd ) {
		
		ModelAndView mv = null;
		mv = new ModelAndView("uploadimg");
		//mv.addObject("message", message);
		//mv.addObject("name", usr);

		return mv;
	}
	
	@RequestMapping(value = { "/uploadSuccess" }, method = RequestMethod.POST)
	public ModelAndView uploadSuccess()
 {
	System.out.println("Image upload");	
		ModelAndView mv = null;
		fpath=fd.filePath;
		mv = new ModelAndView("message");
		mv.addObject("message", "Done");
		//mv.addObject("name", usr);

		return mv;
	}

	/*@RequestMapping(value={"/addProduct"},method=RequestMethod.POST)
	public String updating(@ModelAttribute("p") Product p)
	{
		
		pservice.update(p);//calls service method
		
plist=pservice.getAll();
Gson gson=new Gson();
String result= gson.toJson(plist);
return result;
	return "home";
	}*/

	
	@RequestMapping("form")
	 public ModelAndView getForm1( @ModelAttribute("p") Product p,BindingResult result) {
	  return new ModelAndView("form");
	 }
	 @RequestMapping("register")
	 public ModelAndView registerUser1(@ModelAttribute("p") Product p,BindingResult result) {
		 pservice.create(p);
	  return new ModelAndView("redirect:list");
	 }
	 
	 
	 @RequestMapping("list")
	 public ModelAndView getList() {
	 List<Product> plist = pservice.getAll();
	  return new ModelAndView("plist", "employeeList", plist);
	 }
	 
	 @RequestMapping("admin/edit")
	 public ModelAndView editUser(@RequestParam int id, @ModelAttribute("p") Product p,BindingResult result) {
	  Product pObject = pservice.getRowById(id);
	  return new ModelAndView("form", "employeeObject", pObject);
	 }
	 
	 @RequestMapping("admin/update")
	 public ModelAndView updateUser(@ModelAttribute Product p) {
	  pservice.updateRow(p);
	  return new ModelAndView("redirect:/admin/Product1");
	 }
	 @RequestMapping("admin/delete")
	 public ModelAndView deleteUser(@RequestParam int id) {
	 pservice.deleteRow(id);
	  return new ModelAndView("redirect:/admin/Product1");
	 }
	 
	 /*@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
		public ModelAndView welcomePage() {

			ModelAndView model = new ModelAndView();
			model.addObject("title", "Spring Security Custom Login Form");
			model.addObject("message", "This is welcome page!");
			model.setViewName("hello");
			return model;

		}*/

		@RequestMapping(value = "/admin**", method = RequestMethod.GET)
		public ModelAndView adminPage1() {

			ModelAndView model = new ModelAndView();
			model.addObject("title", "Spring Security Custom Login Form");
			model.addObject("message", "This is protected page!");
			model.setViewName("admin");

			return model;

		}

		@RequestMapping(value = "/user**", method = RequestMethod.GET)
		public ModelAndView adminPage2() {

			ModelAndView model = new ModelAndView();
			model.addObject("title", "Spring Security Custom Login Form");
			model.addObject("message", "This is protected page!");
			model.setViewName("user");

			return model;

		}
		
		//Spring Security see this :
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Invalid username and password!");
			}

			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			}
			 System.out.println("before fetching from db");
			model.setViewName("login");
			System.out.println("after fetching from db");
			return model;

		}

		/*@RequestMapping("/login")
		   public String login(@RequestParam (value="error", required = false) String error,
		                       @RequestParam (value="logout", required = false) String logout, Model model
		                       ) 
		   {

		       if(error != null) 
		       {
		           model.addAttribute("error", "Invalid username and password!");
		       }
		       if(logout!= null) 
		       {
		           model.addAttribute("msg", "You have been logged out successfully.");
		       }
		       return "login";
		}*/
		/*@RequestMapping("/admin")
	    public String adminPage() 
		{
	        return "admin";
	    }*/
		
		@RequestMapping("/register1")
		 public ModelAndView registerUser(@ModelAttribute("u") User u) {
	  return new ModelAndView("register");
	 }
		
		@ModelAttribute("cs")//This refers to command name which we gave 
		public User createuser()
		{
		System.out.println("inside usermodelattribute");
		return new User();//creating a model object
		}
		@RequestMapping(value={"/addc"},method=RequestMethod.POST)
		public ModelAndView adding(@Valid @ModelAttribute("cs") User cs,BindingResult result,Model model)
		{
			if (result.hasErrors()) {
	            return new ModelAndView("register");
	        }
			List<User> usersDetailList=uservice.getAll();

	        for (int i=0; i< usersDetailList.size(); i++) {
	            if(cs.getCusEmail().equals(usersDetailList.get(i).getCusEmail())) {
	                model.addAttribute("emailMsg", "Email already exists");

	                return new ModelAndView("register");
	            }

	            if(cs.getCusName().equals(usersDetailList.get(i).getCusName())) {
	                model.addAttribute("usernameMsg", "Username already exists");

	                return new ModelAndView("register");
	            }
	        }

	       
	       

	      
			System.out.println("inserting user"+cs.getCusName());
			uservice.createu(cs);//calls service method 
			
	/*plist=pservice.getAll();
	Gson gson=new Gson();
	String result= gson.toJson(plist);
	return result;*/
		return new ModelAndView("redirect:login");
		}
		

		//for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied() {

		  ModelAndView model = new ModelAndView();
			
		  //check if user is login
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			User userDetail = (User) auth.getPrincipal();	
			model.addObject("username", userDetail.getCusName());
		  }
			
		  model.setViewName("403");
		  return model;

		}

		
}
