import bulmaCalendar from './bulma-calendar.min';
import bulmaCarousel from './bulma-carousel-modified';

document.addEventListener('DOMContentLoaded', () => {

  var carousels = bulmaCarousel.attach();
  console.log(carousels.length);

  var slideDots = document.getElementById('carousel-navigation-dots');
  var slides = document.querySelectorAll('.carousel-item');
  var insideHtml = '';

  for(i = 0; i < slides.length; i++ ) {
    insideHtml += `<span id="carousel-navigation-slide-icon-${i}" class="level-item icon"><i class="${slides[i].className === 'carousel-item is-active' ? 'fas' : 'far'} fa-circle"></i></span>`;
  }

  slideDots.innerHTML = insideHtml;

  carousels.forEach(instance => {
    instance.on('carousel:slide:after', slide => {
      console.log('carousel-navigation-slide-icon-' + slide.node.dataset.slideIndex);
      var slideEl = document.getElementById('carousel-navigation-slide-icon-' + slide.node.dataset.slideIndex);
      slideEl.innerHTML = '<i class="fas fa-circle"></i>';

      var prevSlideIndex = slide.node.dataset.slideIndex === '0' ? document.querySelectorAll('[data-slide-index]').length - 1 : slide.node.dataset.slideIndex - 1;
      var prevSlideEl = document.getElementById('carousel-navigation-slide-icon-' + prevSlideIndex);

      prevSlideEl.innerHTML = '<i class="far fa-circle"></i>';
    });
  });

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
