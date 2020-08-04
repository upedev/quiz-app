$( document ).ready(function($) {
$('[data-countdown]').each(function() {
     var $this = $(this), finalDate = $(this).data('countdown');
     $this.countdown(finalDate, function(event) {
       $this.html(event.strftime('%D d : %H h : %M m : %S s'));
     }).on('finish.countdown', function() {
        $(this).hide();
     });
   });


$('.option').on('click', function () {
    var optionList = $(this).closest('ul').children();
    optionList.find('button').removeClass("active-option");
    $(this).addClass("active-option");
});

$('.submit-test').on('click', function() {
    var submitMap = new Object();
    var responseMap = new Object();
    var $this = $(this)
    var testId = Cookies.get("test_id");
    var userId = Cookies.get("user_id");
    submitMap['test_id'] = testId;
    submitMap['user_id'] = userId;
    $this.attr("disabled", true);
    $this.text("SUBMITTING...");
    $this.append('<span class="spinner-border spinner-border-sm" style="width: 1.5rem; height: 1.5rem; margin-left: 10px;" role="status" aria-hidden="true"></span>');
    $('.question').each(function(i) {
        var qId = $(this).attr('id');
        var opId = $(this).find('.active-option').attr('id');
        responseMap[qId] = opId;
    })

    submitMap['response_map'] = responseMap

$.ajax({
    url :'http://localhost:8083/submit',
    type : 'POST',
    data : JSON.stringify(submitMap),
    dataType: "json",
    contentType: "application/json;charset=utf-8",
    success : function(data) { location.href = "../submitResult"; },
    error : function(request,error)
        {alert("Request: "+JSON.stringify(request));}

});
});

});
