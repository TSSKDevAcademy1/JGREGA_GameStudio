package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorld extends HttpServlet {
	int helper = 0;
	final Map<String, String> map = new TreeMap<String, String>   (String.CASE_INSENSITIVE_ORDER);	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "";
		String password  = "";	
		String age = "0";
		int Iage = 0;
		String nameVal = "";
		String passVal = "";
		String ageVal = "";
		boolean validName = false, validPass = false, validAge = false;
		
		PrintWriter out = response.getWriter();	
		
		response.setContentType("text/html"); // davam vediet browseru co mu posielam 
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello world</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.printf("<img src=\"resources/gfx/wildfly_400x130.jpg\"><br>"); // posielam mu tam parameter name		
		
		////////////////////////////////////////////////////
		out.println("<form action=\"hello\" method=\"post\">"); // formular (post nezobrazi zadane udaje v URL) ACTION = (vypise tam namiesto zadanych udajov "HELLO")
		/////////////////////////////////////////////////////
		
		name = request.getParameter("meno");		
		nameVal = name;
		out.printf("Name: <input type = \"text\" name=\"meno\" value=\""+nameVal+"\"> "); // okno pre pisanie	
		name = request.getParameter("meno");		
		nameVal = name;
		if(name.length() >= 5 && name.length() <=10 ){
			out.printf("<br>");
			validName = true;
		}else{
			out.printf("Zle meno (Zadaj 5 az 10 znakov) <br>");
			validName = false;
		}		
		
		password = request.getParameter("heslo");		
		out.printf("Password: <input type = \"password\" name=\"heslo\" value=\""+passVal+"\"> "); // okno pre pisanie				
		if(haveNumber(password) > 0 && password.length() <=10 && password.length() >= 5){
			passVal = "*****";
			out.printf("<br>");
			validPass = true;
		}else{
			out.printf("Zle heslo (Zadaj 5 az 10 znakov a cislicu) <br>");		
			validPass = false;
		}
				
		age = request.getParameter("vek");	
		ageVal = age + "";	
		out.printf("Age: <input type = \"number\" name=\"vek\" value=\"" + ageVal + "\"> "); // okno// pre// pisanie												
		try{
			Iage = Integer.parseInt(age);												
		if (Iage <= 150 && Iage > 0) {
			out.printf("<br>");
			validAge = true;
		} else {
			out.printf("Zly vek (Zadaj od 1 do 150 rokov) <br>");
			validAge = false;
		}
		}catch(NumberFormatException e){
			out.printf("Zly vek (Zadaj od 1 do 150 rokov) <br>");
			out.printf("<br>");			
			validAge = false;
		}			

		//////////////////////////////////////////
		out.println("Country: <select name=\"selektor\">");		
			for(int i = 1; i <= map.size();i++){
				out.printf("<option value="+map.get(i + "")+">"+map.get(i + "")+"</option> ");
			}
			
		out.println("</select>");
		/////////////////////////////////////////
		String country=request.getParameter("selektor");
		
		out.println("<input type = \"submit\" name=\"Send\" value=\" Send!\" >"); // tlacidlo submit
		///////////////////////////////////////////
		out.println("</form>");
		///////////////////////////////////////////////////		
		if(validName && validPass && validAge){
		out.printf("<h1>Hello %s from %s, you are %s years old\n</h1>",name,country,age); // posielam mu tam parameter name
		}else{
			
		}
	
		out.println("</body>");
		out.println("</html>");		
		
		System.out.println(map.get(1 + ""));
	}
	///////////////////////////////////////////////////
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp); // vola sa ked je zavolana zo strany klienta na server
	}
	/////////////////////////////////////////////
	private int haveNumber(String password) {
		helper = 0;
		for (char c : password.toCharArray()) {
			if (Character.isDigit(c)) {
				helper++;
			}
		}
		return helper;
	}
	
	//////////////////////////////////////////////////////////
	public HelloWorld() {

		 map.put("1", "Andorra, Principality Of");
		 map.put("2", "United Arab Emirates");
		 map.put("3", "Afghanistan, Islamic State Of");
		 map.put("4","Antigua And Barbuda");
		 map.put("5","Anguilla");
		 map.put("6","Albania");
		 map.put("7","Armenia");
		 map.put("8","Netherlands Antilles");
		 map.put("9","Angola");
		 map.put("10","Antarctica");
		 map.put("11","Argentina");
		 map.put("12","American Samoa");
		 map.put("13","Austria");
		 map.put("14","Australia");
		 map.put("15","Aruba");
		 map.put("16","Azerbaidjan");
		 map.put("17","Bosnia-Herzegovina");
		 map.put("18","Barbados");
		 map.put("19","Bangladesh");
		 map.put("20","Belgium");
		 map.put("21","Burkina Faso");
		 map.put("22","Bulgaria");
		 map.put("23","Bahrain");
		 map.put("24","Burundi");
		 map.put("25","Benin");
		 map.put("26","Bermuda");
		 map.put("27","Brunei Darussalam");
		 map.put("28","Bolivia");
		 map.put("29","Brazil");
		 map.put("30","Bahamas");
		 map.put("31","Bhutan");
		 map.put("32","Bouvet Island");
		 map.put("33","Botswana");
		 map.put("34","Belarus");
		 map.put("35","Belize");
		 map.put("36","Canada");
		 map.put("37","Cocos (Keeling) Islands");
		 map.put("38","Central African Republic");
		 map.put("39","Congo, The Democratic Republic Of The");
		 map.put("40","Congo");
		 map.put("41","Switzerland");
		 map.put("42","Ivory Coast (Cote D'Ivoire)");
		 map.put("43","Cook Islands");
		 map.put("44","Chile");
		 map.put("45","Cameroon");
		 map.put("46","China");
		 map.put("47","Colombia");
		 map.put("48","Costa Rica");
		 map.put("49","Former Czechoslovakia");
		 map.put("50","Cuba");
		 map.put("51","Cape Verde");
		 map.put("52","Christmas Island");
		 map.put("53","Cyprus");
		 map.put("54","Czech Republic");
		 map.put("55","Germany");
		 map.put("56","Djibouti");
		 map.put("57","Denmark");
		 map.put("58","Dominica");
		 map.put("59","Dominican Republic");
		 map.put("60","Algeria");
		 map.put("61","Ecuador");
		 map.put("62","Estonia");
		 map.put("63","Egypt");
		 map.put("64","Western Sahara");
		 map.put("65","Eritrea");
		 map.put("66","Spain");
		 map.put("67","Ethiopia");
		 map.put("68","Finland");
		 map.put("69","Fiji");
		 map.put("70","Falkland Islands");
		 map.put("71","Micronesia");
		 map.put("72","Faroe Islands");
		 map.put("73","France");
		 map.put("74","France (European Territory)");
		 map.put("75","Gabon");
		 map.put("76","Great Britain");
		 map.put("77","Grenada");
		 map.put("78","Georgia");
		 map.put("79","French Guyana");
		 map.put("80","Ghana");
		 map.put("81","Gibraltar");
		 map.put("82","Greenland");
		 map.put("83","Gambia");
		 map.put("84","Guinea");
		 map.put("85","Guadeloupe (French)");
		 map.put("86","Equatorial Guinea");
		 map.put("87","Greece");
		 map.put("88","S. Georgia & S. Sandwich Isls.");
		 map.put("89","Guatemala");
		 map.put("90","Guam (USA)");
		 map.put("91","Guinea Bissau");
		 map.put("92","Guyana");
		 map.put("93","Hong Kong");
		 map.put("94","Heard And McDonald Islands");
		 map.put("95","Honduras");
		 map.put("96","Croatia");
		 map.put("97","Haiti");
		 map.put("98","Hungary");
		 map.put("99","Indonesia");
		 map.put("100","Ireland");
		 map.put("101","Israel");
		 map.put("102","India");
		 map.put("103","British Indian Ocean Territory");
		 map.put("104","Iraq");
		 map.put("105","Iran");
		 map.put("106","Iceland");
		 map.put("107","Italy");
		 map.put("108","Jamaica");
		 map.put("109","Jordan");
		 map.put("110","Japan");
		 map.put("111","Kenya");
		 map.put("112","Kyrgyz Republic (Kyrgyzstan)");
		 map.put("113","Cambodia, Kingdom Of");
		 map.put("114","Kiribati");
		 map.put("115","Comoros");
		 map.put("116","Saint Kitts & Nevis Anguilla");
		 map.put("117","North Korea");
		 map.put("118","South Korea");
		 map.put("119","Kuwait");
		 map.put("120","Cayman Islands");
		 map.put("121","Kazakhstan");
		 map.put("122","Laos");
		 map.put("123","Lebanon");
		 map.put("124","Saint Lucia");
		 map.put("125","Liechtenstein");
		 map.put("126","Sri Lanka");
		 map.put("127","Liberia");
		 map.put("128","Lesotho");
		 map.put("129","Lithuania");
		 map.put("130","Luxembourg");
		 map.put("131","Latvia");
		 map.put("132","Libya");
		 map.put("133","Morocco");
		 map.put("134","Monaco");
		 map.put("135","Moldavia");
		 map.put("136","Madagascar");
		 map.put("137","Marshall Islands");
		 map.put("138","Macedonia");
		 map.put("139","Mali");
		 map.put("140","Myanmar");
		 map.put("141","Mongolia");
		 map.put("142","Macau");
		 map.put("143","Northern Mariana Islands");
		 map.put("144","Martinique (French)");
		 map.put("145","Mauritania");
		 map.put("146","Montserrat");
		 map.put("147","Malta");
		 map.put("148","Mauritius");
		 map.put("149","Maldives");
		 map.put("150","Malawi");
		 map.put("151","Mexico");
		 map.put("152","Malaysia");
		 map.put("153","Mozambique");
		 map.put("154","Namibia");
		 map.put("155","New Caledonia (French)");
		 map.put("156","Niger");
		 map.put("157","Norfolk Island");
		 map.put("158","Nigeria");
		 map.put("159","Nicaragua");
		 map.put("160","Netherlands");
		 map.put("161","Norway");
		 map.put("163","Nepal");
		 map.put("164","Nauru");
		 map.put("165","Neutral Zone");
		 map.put("166","Niue");
		 map.put("167","New Zealand");
		 map.put("168","Oman");
		 map.put("169","Panama");
		 map.put("170","Peru");
		 map.put("171","Polynesia (French)");
		 map.put("172","Papua New Guinea");
		 map.put("173","Philippines");
		 map.put("174","Pakistan");
		 map.put("175","Poland");
		 map.put("176","Saint Pierre And Miquelon");
		 map.put("177","Pitcairn Island");
		 map.put("178","Puerto Rico");
		 map.put("179","Portugal");
		 map.put("180","Palau");
		 map.put("181","Paraguay");
		 map.put("182","Qatar");
		 map.put("183","Reunion (French)");
		 map.put("184","Romania");
		 map.put("185","Russian Federation");
		 map.put("186","Rwanda");
		 map.put("187","Saudi Arabia");
		 map.put("188","Solomon Islands");
		 map.put("189","Seychelles");
		 map.put("190","Sudan");
		 map.put("191","Sweden");
		 map.put("192","Singapore");
		 map.put("193","Saint Helena");
		 map.put("194","Slovenia");
		 map.put("195","Svalbard And Jan Mayen Islands");
		 map.put("196","Slovak Republic");
		 map.put("197","Sierra Leone");
		 map.put("198","San Marino");
		 map.put("199","Senegal");
		 map.put("200","Somalia");
		 map.put("201","Suriname");
		 map.put("202","Saint Tome (Sao Tome) And Principe");
		 map.put("203","Former USSR");
		 map.put("204","El Salvador");
		 map.put("205","Syria");
		 map.put("206","Swaziland");
		 map.put("207","Turks And Caicos Islands");
		 map.put("208","Chad");
		 map.put("209","French Southern Territories");
		 map.put("210","Togo");
		 map.put("211","Thailand");
		 map.put("212","Tadjikistan");
		 map.put("213","Tokelau");
		 map.put("214","Turkmenistan");
		 map.put("215","Tunisia");
		 map.put("216","Tonga");
		 map.put("217","East Timor");
		 map.put("218","Turkey");
		 map.put("219","Trinidad And Tobago");
		 map.put("220","Tuvalu");
		 map.put("221","Taiwan");
		 map.put("222","Tanzania");
		 map.put("223","Ukraine");
		 map.put("224","Uganda");
		 map.put("225","United Kingdom");
		 map.put("226","USA Minor Outlying Islands");
		 map.put("227","United States");
		 map.put("228","Uruguay");
		 map.put("229","Uzbekistan");
		 map.put("230","Holy See (Vatican City State)");
		 map.put("231","Saint Vincent & Grenadines");
		 map.put("232","Venezuela");
		 map.put("233","Virgin Islands (British)");
		 map.put("234","Virgin Islands (USA)");
		 map.put("235","Vietnam");
		 map.put("236","Vanuatu");
		 map.put("237","Wallis And Futuna Islands");
		 map.put("238","Samoa");
		 map.put("239","Yemen");
		 map.put("240","Mayotte");
		 map.put("241","Yugoslavia");
		 map.put("242","South Africa");
		 map.put("243","Zambia");
		 map.put("244","Zaire");
		 map.put("245","Zimbabwe");

		}	
}


