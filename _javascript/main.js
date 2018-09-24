document.addEventListener('DOMContentLoaded', () => {
  // console.log('Hello Bulma!');

  // var carousels = bulmaCarousel.attach(); // carousels now contains an array of all Carousel instances

  //   var datePickers = bulmaCalendar.attach('[type="date"]', {
  //   overlay: true,
  //   minDate: '2018-06-01',
  //   maxDate: '2018-12-31'
  // });

  // Initialize all input of date type.
var calendars = bulmaCalendar.attach('[type="date"]', {displayMode: 'inline', startDate: new Date(), clearButton: false});

// Loop on each calendar initialized
for(var i = 0; i < calendars.length; i++) {
	// Add listener to date:selected event
	calendars[i].on('date:selected', date => {
		console.log(date);
	});
}

});
