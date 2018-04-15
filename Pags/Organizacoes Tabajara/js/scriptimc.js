$('#calc').click(function () {
    var numero1 = $('#peso').val();
    var numero2 = $('#altura').val();
    var resultado = numero1/(numero2 * numero2);
    for (let index = 1; index < 7; index++) {
       $('#lin-'+index).addClass("branco");
       $('#'+index).text(" ");
     }
     if($('#checmen').prop('checked')){
      if(resultado < 18.5){
       $('#lin-1').addClass("red");
       $('#1').text("Você");
       //add imagem
      //  $('#1').prepend('<img src="../imagens/magro.png" alt="magropng">');
    }else{
      if(resultado >= 18.5 && resultado <= 24.9){
         $('#lin-2').addClass("red");
         $('#2').text("Você");
      }else{
        if(resultado >= 25 && resultado <= 29.9){
          $('#lin-3').addClass("red");
          $('#3').text("Você");
        }else{
          if(resultado >= 30 && resultado <= 34.9){
            $('#lin-4').addClass("red");
            $('#4').text("Você");
          }else{
            if(resultado >= 35 && resultado <= 39.9){
              $('#lin-5').addClass("red");
              $('#5').text("Você");
            }else{
              $('#lin-6').addClass("red");
              $('#6').text("Você");
            }
          }
        }
      }
    } 
     }
    
    $('#result-imc').text(resultado);
});   