<%-- 
    Document   : index
    Created on : 17 Jun, 2017, 3:09:17 PM
    Author     : venkatesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"/>

        <!-- Include FontAwesome CSS if you want to use feedback icons provided by FontAwesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

        <!-- BootstrapValidator CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css"/>

        <!-- jQuery and Bootstrap JS -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>

        <!-- BootstrapValidator JS -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>

        <!-- Own JS -->
        <script type="text/javascript" src="js/form.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="btn-group" role="group"style="padding: 10px">
                <button type="button" data-toggle="collapse" data-target="#div1" id="showAdd" class="btn btn-lg" >Add</button>
                <button type="button" data-toggle="collapse" data-target="#div2" id="showUpdate" class="btn btn-lg">Edit</button>
                <button type="button" data-toggle="collapse" data-target="#div3" id="showDelete" class="btn btn-lg">Remove</button>
                <button type="button" data-toggle="collapse" data-target="#div4" id="showTable" class="btn btn-lg">Table</button>
            </div>
            <div id="div1" style="display:none">
                <form class="form-horizontal" style="padding: 10px">
                    <div class="form-group ">
                        <label class="col-sm-2 control-label" for="a_name">Customer Name</label>
                        <div class="col-sm-3">
                            <input class="form-control" type="text" name="a_name" id="ac_name">
                        </div>
                    </div>
                    <div class="form-group ">
                        <label class="col-sm-2 control-label" for="a_email">Customer Email</label>
                        <div class="col-sm-3">
                            <input class="form-control" type="text" name="a_email" id="ac_email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="a_cntry">Country</label>
                        <div class="col-sm-3">
                            <select class="form-control" name="a_cntry" id="ac_cntry">
                                <option value="India">India</option>
                                <option value="Germany">Germany</option>
                                <option value="Japan">Japan</option>
                                <option value="China">China</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-5 control-label">
                            <button type="button" class="btn btn-info" id="add">Add</button>
                        </div>
                    </div>
                </form>
            </div>
            <div id="div2" style="display:none">
                <form class="form-horizontal" style="padding: 10px">
                    <div class="form-inline">
                        <label class="col-sm-2 control-label" for="c_id">Enter Customer ID</label>
                        <input class="form-control" type="text" name="c_id" id="uc_id">
                        <button type="button" class="btn btn-info" id="u_fetch">Fetch</button>
                        <button type="button" class="btn btn-info" id="update">Update</button>
                    </div>
                    <div class="form-horizontal" id="updateDetails" style="padding: 10px"></div>
                </form>
            </div>
            <div id="div3" style="display:none">
                <form class="form-horizontal" style="padding: 10px">
                    <div class="form-inline">
                        <label class="col-sm-2 control-label" for="c_id">Enter Customer ID</label>
                        <input class="form-control" type="text" name="c_id" id="dc_id">
                        <button type="button" class="btn btn-info" id="d_fetch">Fetch</button>
                        <button type="button" class="btn btn-info" id="delete">Delete</button>
                    </div>
                    <div class="form-group" id="deleteDetails" style="padding: 10px"></div>
                </form>
            </div>
            <div id="div4" style="display: none">
                <table class="table table-striped table-bordered table-hover table-condensed" align="center" id="tableDetails" border="1"></table>
            </div>
        </div>
    </body>
</html>
