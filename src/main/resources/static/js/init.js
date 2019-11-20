(function($){
  $(function(){

    $('.sidenav').sidenav();
    $('.parallax').parallax();
    $('.dropdown-trigger').dropdown({coverTrigger: false, constrainWidth: false});
    $('.collapsible').collapsible();
    $('.modal').modal();
    $('select').formSelect();

  }); // end of document ready
})(jQuery); // end of jQuery name space
