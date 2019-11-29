"use strict";

/*
   New Perspectives on HTML5 and CSS3, 7th Edition
   Tutorial 10
   Review Assignment

   Author: Lewis Kern
   Date:   2018-03-01

	
*/


/* Write the HTML code for the event list table */
var tableHTML = "<table id='classSchedule'>";
tableHTML += "<caption>2019 Classes</caption>";
tableHTML += "<p>This took entirely too long, Russ.</p>";
tableHTML += "<tr><th>Time</th><th>08:30</th><th>10:30</th><th>13:30</th>";
/* Loop through the eventDates array */
tableHTML += "<tr>";
tableHTML += "<th>Monday</th>";
   if (monday) {
      tableHTML += "<td>" + monday.courses["0830"] +"<td>" +  monday.courses["1030"] +"<td>" +  monday.courses["1330"] +  "</td>";
}
tableHTML += "<tr>";
tableHTML += "<th>Tuesday</th>";
if (tuesday) {
   tableHTML += "<td>" + tuesday.courses["0830"] +"<td>" +  tuesday.courses["1030"] +"<td>" +  tuesday.courses["1330"] +  "</td>";
}
tableHTML += "<tr>";
tableHTML += "<th>Wednesday</th>";
if (wednesday) {
   tableHTML += "<td>" + wednesday.courses["0830"] +"<td>" +  wednesday.courses["1030"] +"<td>" +  wednesday.courses["1330"] +  "</td>";
}
tableHTML += "<tr>";
tableHTML += "<th>Thursday</th>";
if (thursday) {
   tableHTML += "<td>" + thursday.courses["0830"] +"<td>" +  thursday.courses["1030"] +"<td>" +  thursday.courses["1330"] +  "</td>";
}
tableHTML += "<tr>";
tableHTML += "<th>Friday</th>";
if (friday) {
   tableHTML += "<td>" + friday.courses["0830"] +"<td>" +  friday.courses["1030"] +"<td>" +  friday.courses["1330"] +  "</td>";
}
tableHTML += "</table>";



/* Write the HTML code into the eventList box */
document.getElementById("eventList").innerHTML = tableHTML;

