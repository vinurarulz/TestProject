package Models;

public class CheckOut {

    public String DisplayNewAddress(String type) {
        String value = "gsgsgsgsg";
        value += "<div class='col-md-6'>";

        value += "<div class='form-group'>";
        value += "<label class='control-label'>Person Name:<span class='text-error'>*</span></label>";
        value += "<div class='row'>";
        value += "<div class='col-md-6'>";
        value += "<input type='text' class='form-control' id='fname-" + type + "' name='fname-" + type + "' placeholder='First Name'>";
        value += "</div>";
        value += "<div class='col-md-6'>";
        value += "<input type='text' class='form-control' id='lname-" + type + "' name='lname-" + type + "' placeholder='Last Name'>";
        value += "</div>";
        value += "</div>";
        value += "</div>";

        value += "<div class='form-group'>";
        value += "<label class='control-label'>Address /1<span class='text-error'>*</span></label>";
        value += "<div>";
        value += "<input class='form-control' id='add1-" + type + "' name='add1-" + type + "'>";
        value += "</div>";
        value += "</div>";

        value += "<div class='form-group'>";
        value += "<label class='control-label'>Address /2</label>";
        value += "<div>";
        value += "<input type='text' class='form-control' id='add2-" + type + "' name='add2-" + type + "'>";
        value += "</div>";
        value += "</div>";

        value += "<div class='form-group'>";
        value += "<label class='control-label'>City:<span class='text-error'>*</span></label>";
        value += "<div>";
        value += "<input type='text' class='form-control' id='add3-" + type + "' name='add3-" + type + "'>";
        value += "</div>";
        value += "</div>";

        value += "</div>";

        value += "<div class='col-md-6'>";

        value += "<div class='form-group'>";
        value += "<label for='inputAdress1' class='control-label'>Post Code:<span class='text-error'>*</span></label>";
        value += "<div>";
        value += "<input type='number' class='form-control' id='postal-" + type + "' name='postal-" + type + "'>";
        value += "</div>";
        value += "</div>";

        value += "<div class='form-group'>";
        value += "<label class='control-label'>District:<span class='text-error'>*</span></label>";
        value += "<div>";
        value += "<select name='district-" + type + "' id='district-" + type + "' class='form-control'>";
        value += "</select>";
        value += "</div>";
        value += "</div>";

        value += "<div class='form-group'>";
        value += "<label class='control-label'>Country:<span class='text-error'>*</span></label>";
        value += "<div>";
        value += "<select name='country-" + type + "' id='country-" + type + "' class='form-control'>";
        value += "<option value='Sri Lanka'>Sri Lanka</option>";
        value += "</select>";
        value += "</div>";
        value += "</div>";

        value += "</div>";
        return value;
    }

    public String TabHeading1() {
        String value = "";
        value += "<li class='active'><a href='#address' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-thumb-tack'></i>Billing Address</a></li>";
        value += "<li><a href='#shipping' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-truck'></i>Shipping Method</a></li>";
        value += "<li><a href='#payment' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-money'></i>Payment Method</a></li>";
        value += "<li><a href='#review' data-toggle='tab' onclick='LoadReturnPolicy()'><i class='fa fa-check'></i>Order Review</a></li>";
        return value;
    }

    public String TabHeading2() {
        String value = "";
        value += "<li><a href='#address' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-thumb-tack'></i>Billing Address</a></li>";
        value += "<li class='active'><a href='#shipping' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-truck'></i>Shipping Method</a></li>";
        value += "<li><a href='#payment' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-money'></i>Payment Method</a></li>";
        value += "<li><a href='#review' data-toggle='tab' onclick='LoadReturnPolicy()'><i class='fa fa-check'></i>Order Review</a></li>";
        return value;
    }

    public String TabHeading3() {
        String value = "";
        value += "<li><a href='#address' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-thumb-tack'></i>Billing Address</a></li>";
        value += "<li><a href='#shipping' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-truck'></i>Shipping Method</a></li>";
        value += "<li class='active'><a href='#payment' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-money'></i>Payment Method</a></li>";
        value += "<li><a href='#review' data-toggle='tab' onclick='LoadReturnPolicy()'><i class='fa fa-check'></i>Order Review</a></li>";
        return value;
    }

    public String TabHeading4() {
        String value = "";
        value += "<li><a href='#address' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-thumb-tack'></i>Billing Address</a></li>";
        value += "<li><a href='#shipping' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-truck'></i>Shipping Method</a></li>";
        value += "<li><a href='#payment' data-toggle='tab' onclick='ClearReturnPolicy()'><i class='fa fa-money'></i>Payment Method</a></li>";
        value += "<li class='active'><a href='#review' data-toggle='tab' onclick='LoadReturnPolicy()'><i class='fa fa-check'></i>Order Review</a></li>";
        return value;
    }

    public String LoadPolicy() {
        String value = "";
        value += "<div class='block-form block-order-total box-border wow fadeInRight' data-wow-duration='1s'>";
        value += "<h3><i class='fa fa-check'></i>Return policy</h3>";
        value += "<blockquote style='text-align: justify;'>";
        value += "Should you wish to return anything bought from us online, we will be happy to exchange the product(s) that we provided "
                + "in fully resaleable condition. <b>But for the returnings you should come & visit our showroom.</b> Returns should be made within a <b>30 days</b> after the ordered date and the product should be in original condition. If you have any question about your purchased items, please feel free to contact us through the mail or telephone.";
        value += "</blockquote>";
        value += "</div>";
        return value;
    }
}
