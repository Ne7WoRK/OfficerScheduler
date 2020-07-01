$(function() {
	$('#dateFrom').datepicker(
			{
				closeText : 'затвори',
				prevText : '<назад',
				nextText : 'напред>',
				nextBigText : '>>',
				currentText : 'днес',
				monthNames : [ 'Януари', 'Февруари', 'Март', 'Април', 'Май',
						'Юни', 'Юли', 'Август', 'Септември', 'Октомври',
						'Ноември', 'Декември' ],
				monthNamesShort : [ 'Яну', 'Фев', 'Мар', 'Апр', 'Май', 'Юни',
						'Юли', 'Авг', 'Сеп', 'Окт', 'Нов', 'Дек' ],
				dayNames : [ 'Неделя', 'Понеделник', 'Вторник', 'Сряда',
						'Четвъртък', 'Петък', 'Събота' ],
				dayNamesShort : [ 'Нед', 'Пон', 'Вто', 'Сря', 'Чет', 'Пет',
						'Съб' ],
				dayNamesMin : [ 'Не', 'По', 'Вт', 'Ср', 'Че', 'Пе', 'Съ' ],
				weekHeader : 'Wk',
				dateFormat : 'dd/mm/yy',
				firstDay : 1,
				isRTL : false,
				minDate: new Date(),
				showMonthAfterYear : false,
				yearSuffix : '',
				onSelect : function(selectedDate) {
					
					
					$("#dateTo").datepicker("option", "minDate", selectedDate);
					setTimeout(function() {
						$("#dateTo").datepicker('show');
					}, 16);
				},
				beforeShow : function() {
					var txtBoxOffset = $(this).offset();
					var top = txtBoxOffset.top;
					var left = txtBoxOffset.left;
				}
			});

	$('#dateTo').datepicker(
			{
				closeText : 'затвори',
				prevText : '<назад',
				nextText : 'напред>',
				nextBigText : '>>',
				currentText : 'днес',
				monthNames : [ 'Януари', 'Февруари', 'Март', 'Април', 'Май',
						'Юни', 'Юли', 'Август', 'Септември', 'Октомври',
						'Ноември', 'Декември' ],
				monthNamesShort : [ 'Яну', 'Фев', 'Мар', 'Апр', 'Май', 'Юни',
						'Юли', 'Авг', 'Сеп', 'Окт', 'Нов', 'Дек' ],
				dayNames : [ 'Неделя', 'Понеделник', 'Вторник', 'Сряда',
						'Четвъртък', 'Петък', 'Събота' ],
				dayNamesShort : [ 'Нед', 'Пон', 'Вто', 'Сря', 'Чет', 'Пет',
						'Съб' ],
				dayNamesMin : [ 'Не', 'По', 'Вт', 'Ср', 'Че', 'Пе', 'Съ' ],
				weekHeader : 'Wk',
				dateFormat : 'dd/mm/yy',
				firstDay : 1,
				isRTL : false,
				showMonthAfterYear : false,
				yearSuffix : '',
				beforeShow : function() {
					var txtBoxOffset = $(this).offset();
					var top = txtBoxOffset.top;
					var left = txtBoxOffset.left;
				}
			});

});

function showDP(cbox) {
	if (cbox.checked) {
		$('#dateFrom').css({
			display : "block"
		});
		$('#dateTo').css({
			display : "block"
		});
	} else {
		$('#dateFrom').css({
			display : "none"
		});
		$('#dateTo').css({
			display : "none"
		});

	}
}

function showDPNew(select) {
	if ($(select).val() == 0) {
		$('#dateFrom').css({
			display : "inline-flex"
		});
		$('#dateTo').css({
			display : "inline-flex"
		});
		$("#dateFrom").focus();
	} else {
		$('#dateFrom').css({
			display : "none"
		});
		$('#dateTo').css({
			display : "none"
		});

		$("#dateFrom").blur();
		$("#dateTo").blur();
	}
}

function openForm() {
	$(document).ready(function() {
		$("#addButton").click(function() {
			document.querySelector('#formBox').style.display = "flex";
			
			$("#custom-avatar").click(function(e) {
				$("#photo").click();
				e.stopPropagation();
				
				$( "#photo" ).change(function() {
					if ($('#photo').val() != 0) {
						customTxt = document.getElementById("custom-text");
						customTxt.innerHTML = $('#photo').val().match(/[\/\\]([\w\d\s\.\-\(\)]+)$/)[1];
					} else {
						customTxt.innerHTML = "Няма избран файл !";
					}
				});	
			});
		});

		$("#closeForm").click(function() {
			document.querySelector('#formBox').style.display = "none";
		});
	});
}