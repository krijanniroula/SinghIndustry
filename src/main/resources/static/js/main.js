

$(document).ready( function () {
	
	$('#kharchaTable,#attendenceTable').DataTable({
		  "paging": true,
	      "lengthChange": false,
	      "searching": false,
	      "bInfo" : false,
	      "info": true,
	      "pagingType": "numbers",
	      "pageLength": 4,
	      "order": [[ 0, "desc" ]],
	      "autoWidth": false,
	      "columnDefs": [ {
	             "targets": 'no-sort',
	             "orderable": false,
	       } ]
	      
	});
	
	//datatable
	var table = $('#example1').DataTable({
		
		  "order": [[ 0, "desc" ]],
		    
    	 "language": {
    		 		search: '<i class="fa fa-search" type="search"></i>',
    		 		searchPlaceholder: "Search"
    			 },
    	
    	 "columnDefs": [ {
             "targets": 'no-sort',
             "orderable": false,
       } ]
     });
    
	//total for quantity and rate
     $('#rate, #quantity').on('input',function(){
    	    var rate = parseFloat($('#rate').val()) || 0;
    	    var quantity = parseFloat($('#quantity').val()) || 0;

    	    $('#total').val(rate * quantity);    
     });
     
   //total for quantity and rate
     $('#rate, #quantity').on('input',function(){
    	    var rate = parseFloat($('#rate').val()) || 0;
    	    var quantity = parseFloat($('#quantity').val()) || 0;

    	    $('#total1').val(rate * quantity);    
     });
     
     $('#rate, #submitted').on('input',function(){
 	    
 	    var submitted = parseFloat($('#submitted').val()) || 0;
 	   var rate = parseFloat($('#rate').val()) || 0;

 	    $('#total').val( submitted*rate);    
  });
     
   //remaining for delivered and quantity
     $('#delivered, #quantity').on('input',function(){
    	    var delivered = parseFloat($('#delivered').val()) || 0;
    	    var quantity = parseFloat($('#quantity').val()) || 0;

    	    $('#remaining').val(quantity - delivered);    
     });
     
   //remaining for amount and total amount
     $('#amount, #total_amount').on('input',function(){
 	    var amount = parseFloat($('#amount').val()) || 0;
 	    var total = parseFloat($('#total_amount').val()) || 0;

 	    $('#remaining').val(total - amount);    
     });
     
       
     
     // default value for datepicker
     function dateToYMD(date) {
    	    var d = date.getDate();
    	    var m = date.getMonth() + 1; 
    	    var y = date.getFullYear();
    	    return y+'-'+(m<=9 ? '0' + m : m)+ '-' + (d <= 9 ? '0' + d : d);
    	}
     
     $('#date').datepicker({
    	 uiLibrary: 'bootstrap4', 
    	 iconsLibrary: 'fontawesome',
    	 format: 'yyyy-mm-dd'
    	 
    	 
 	});
     
     $('#date1').datepicker({
    	 uiLibrary: 'bootstrap4', 
    	 iconsLibrary: 'fontawesome',
    	 format: 'yyyy-mm-dd'
    	 
 	});
     
     if ($('#date1,#date').val() == '')
     { 
    	 $('#date1,#date').val(dateToYMD(new Date()));
     }
    
     
     // datatable print button append in navbar div
     var buttons = new $.fn.dataTable.Buttons(table, {
    	 dom: {
    		    button: {
    		      className: 'btn btn-primary fa fa-print'
    		    }
    		  },
    	 buttons: [{
	    	 extend: 'print',
             exportOptions: {
            	 columns: ':not(:last-child)'
             },
             
	     }],
    }).container().appendTo($('#btnPrint'));
     
  // kharcha table  
    
});






