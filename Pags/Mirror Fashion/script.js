$(function(){
    // Activate Carousel
    $("#myCarousel").carousel();
    
    // Enable Carousel Indicators
    $(".item0").click(function(){
        $("#carouselExampleIndicators").carousel(0);
    });
    $(".item1").click(function(){
        $("#carouselExampleIndicators").carousel(1);
    });
    $(".item2").click(function(){
        $("#carouselExampleIndicators").carousel(2);
    });
    
    // Enable Carousel Controls
    $(".left").click(function(){
        $("#carouselExampleIndicators").carousel("prev");
    });
    $(".right").click(function(){
        $("#carouselExampleIndicators").carousel("next");
    });
});