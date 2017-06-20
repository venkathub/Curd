$(document).ready(function () {
    $("#showAdd").click(function () {
        $('div[id^=div]').hide();
        $("#div1").toggle(1000);
        $("#add").click(function () {
            var acname = $("#ac_name").val();
            var acemail = $("#ac_email").val();
            var accntry = $("#ac_cntry").val();
            $.post("insert",
                    {
                        CustomerName: acname,
                        CustomerEmail: acemail,
                        CustomerCountry: accntry
                    },
                    function () {
                        alert("Added Successfully");
                    });
        });
    });

    $("#showUpdate").click(function () {
        $('div[id^=div]').hide();
        $("#div2").toggle(1000);
        $("#u_fetch").click(function () {
            var ucid = $("#uc_id").val();
            $.get("fetch",
                    {
                        CustomerID: ucid
                    },
                    function (data) {
                        $("#updateDetails").html(data);
                        alert("Fetched");
                    });
        });
    });
    $("#update").click(function () {
        var ucid = $("#uc_id").val();
        var ucname = $("#uc_name").val();
        var ucemail = $("#uc_email").val();
        var uccntry = $("#uc_cntry").val();
        $.post("update",
                {
                    CustomerID: ucid,
                    CustomerName: ucname,
                    CustomerEmail: ucemail,
                    CustomerCountry: uccntry
                },
                function () {
                    alert("Updated Succesfully");
                });
    });

    $("#showDelete").click(function () {
        $('div[id^=div]').hide();
        $("#div3").toggle(1000);
        $("#d_fetch").click(function () {
            var dcid = $("#dc_id").val();
            $.get("delete",
                    {
                        CustomerID: dcid
                    },
                    function (data) {
                        $("#deleteDetails").html(data);
                    });
        });
    });
    $("#delete").click(function () {
        var ucid = $("#dc_id").val();
        $.post("delete",
                {
                    CustomerID: ucid
                },
                function () {
                    alert("Deleted Succesfully");
                });
    });
    
    $("#showTable").click(function () {
        $('div[id^=div]').hide();
        $("#div4").toggle(1000);
        $.get("table",
                function (data) {
                    $("#tableDetails").html(data);
                });
    });
});