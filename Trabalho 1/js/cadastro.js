<script src="../js/jquery.js"></script>;
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>;

$(document).ready(function () { 
    var $seuCampoTel = $("#tel");
    $seuCampoTel.mask('(00) 00000-0000', {reverse: false});
});

