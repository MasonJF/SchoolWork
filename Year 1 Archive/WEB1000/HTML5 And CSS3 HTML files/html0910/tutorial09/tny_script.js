"use strict";

/*
   New Perspectives on HTML5 and CSS3, 7th Edition
   Tutorial 9
   Tutorial Case

   Countdown Clock
   Author: Mason Fraser
   Date:   11 29 18

*/
runClock();
setInterval("runClock()", 1000);
/*function to create and run the countdown clock */
function runClock() {
  /*Store the current date and time */
  var currentDay = new Date();
  var dateStr = currentDay.toLocaleDateString();
  var timeStr = currentDay.toLocaleTimeString();


  /*Display the current date and time */
  document.getElementById("dateNow").innerHTML = dateStr + "<br />" + timeStr;


  /*Calculate the days left till New Years */
  var newYear = new Date("January 1, 2019");
  var nextYear = currentDay.getFullYear() + 1;
  newYear.setFullYear(nextYear);
  var daysLeft = (newYear - currentDay)/(1000*60*60*24);

  /*Calculate the days left till New Years */
  var hrsLeft = (daysLeft - Math.floor(daysLeft))*24;
  var minsLeft = (hrsLeft - Math.floor(hrsLeft))*60;
  var secLeft = (minsLeft - Math.floor(minsLeft))*60;
  /* Disply the time left until New Year's Eve */
  document.getElementById("days").textContent = Math.floor(daysLeft);
  document.getElementById("hrs").textContent = Math.floor(hrsLeft);;
  document.getElementById("mins").textContent = Math.floor(minsLeft);
  document.getElementById("secs").textContent = Math.floor(secLeft);

}
