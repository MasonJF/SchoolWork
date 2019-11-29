
// https://api.jquery.com/jquery.ajax/
// The include script "jquery.min.js" pulls in this API
//

setInterval(function() {     // https://api.jquery.com/ready/#entry-examples

    $.getJSON( "/greetingRandom", function( data ) {
        $.each( data, function( key, val ) {
            console.log(" key= " + key + "  val= " + val );
        });
        $('.greeting-id').text(data.id);
        $('.greeting-content').text(data.content);
        $('.greeting-random').text(data.random);

    });

}, 1000);

