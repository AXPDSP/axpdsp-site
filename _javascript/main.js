import bulmaCalendar from './bulma-calendar.min';
import bulmaCarousel from './bulma-carousel-modified';
import moment from '../node_modules/moment';
import _ from '../node_modules/lodash';

document.addEventListener('DOMContentLoaded', () => {

  var carousels = bulmaCarousel.attach();
  // console.log(carousels.length);

  var slideDots = document.getElementById('carousel-navigation-dots');
  var slides = document.querySelectorAll('.carousel-item');
  var insideHtml = '';

  for(i = 0; i < slides.length; i++ ) {
    insideHtml += `<span id="carousel-navigation-slide-icon-${i}" class="level-item icon"><i class="${slides[i].className === 'carousel-item is-active' ? 'fas' : 'far'} fa-circle"></i></span>`;
  }

  slideDots.innerHTML = insideHtml;

  carousels.forEach(instance => {
    instance.on('carousel:slide:after', slide => {
      // console.log('carousel-navigation-slide-icon-' + slide.node.dataset.slideIndex);
      var slideEl = document.getElementById('carousel-navigation-slide-icon-' + slide.node.dataset.slideIndex);
      slideEl.innerHTML = '<i class="fas fa-circle"></i>';

      var prevSlideIndex = slide.node.dataset.slideIndex === '0' ? document.querySelectorAll('[data-slide-index]').length - 1 : slide.node.dataset.slideIndex - 1;
      var prevSlideEl = document.getElementById('carousel-navigation-slide-icon-' + prevSlideIndex);

      prevSlideEl.innerHTML = '<i class="far fa-circle"></i>';
    });
  });

  const rushDates = [
    {
      name: 'House Tours',
      day: moment('2018-11-05'),
      time: {
        start: '5:30PM',
        end: '8:30PM'
      }
    },
    {
      name: 'House Tours (2)',
      day: moment('2018-11-07'),
      time: {
        start: '5:30PM',
        end: '8:30PM'
      }
    },
    {
      name: 'Car Smash',
      day: moment('2018-11-10'),
      time: {
        start: '1:00PM',
        end: ''
      }
    },
    {
      name: 'Archery Tag',
      day: moment('2018-11-12'),
      time: {
        start: '6:30PM',
        end: ''
      }
    },
    {
      name: 'Video Game Night',
      day: moment('2018-11-14'),
      time: {
        start: '6:00PM',
        end: ''
      }
    },
    {
      name: 'Kung Fu Night',
      day: moment('2018-11-16'),
      time: {
        start: '5:30PM',
        end: ''
      }
    },
    {
      name: 'Casino Night',
      day: moment('2018-11-19'),
      time: {
        start: '6:00PM',
        end: ''
      }
    }
  ];

  // Initialize all input of date type.
  var calendars = bulmaCalendar.attach('[type="date"]', {displayMode: 'inline', startDate: new Date(), clearButton: false});

  const listWrapper = document.getElementById('recruitment-upcoming-events-list');
  _.each(rushDates, (event, index) => {
    let li = document.createElement('li');
    li.classList.add('upcoming-event-list-item');
    li.setAttribute('id', `upcoming-event-list-item-${index}`);
    li.appendChild(document.createTextNode(`${event.name}: ${event.day.format('ddd MMM Do').toString()} (${event.time.start})`));
    li.addEventListener('click', (ev) => {
      calendars[0].value(rushDates[index].day.toDate()); //bug in library -- does not actually set value...
    });
    listWrapper.appendChild(li);
  });

  // Loop on each calendar initialized
  for(var i = 0; i < calendars.length; i++) {
    // Add listener to date:selected event
    calendars[i].on('date:selected', date => {
      const rushEventListItems = document.querySelectorAll('.upcoming-event-list-item');
      // console.log(rushEventListItems);

      _.each(rushEventListItems, (eventListItem) => {
        eventListItem.classList.remove('upcoming-event-list-item-selected');
      });

      const selected = moment(date.start);
      // console.log('picked date', selected);

      _.each(rushDates, (event, index) => {
          // console.log(selected.toString(), day.toString());
          if(selected.isSame(event.day, 'day')) {
          // console.log('selected matched!');
           const eventEl = document.getElementById(`upcoming-event-list-item-${index}`);
           eventEl.classList.add('upcoming-event-list-item-selected');
          }
      });
    });
  }
});
