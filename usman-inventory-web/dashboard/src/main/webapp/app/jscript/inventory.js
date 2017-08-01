/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//////////////////////////////////////////////////
//////////////////////Customer Details////////////
//////////////////////////////////////////////////

function openNewCustomer()
{
    window.location.href = "new";
}

function confirmCsutomerDelete()
{
    if(confirm('Are you sure want to delete this customer?'))
    {
        return true;
    }
    return false;
}

function  updateCustomer()
{
    form = document.getElementById('customer');
    form.action = 'update';
    form.submit();
}
function resetCustomer()
{
    document.forms[0].name.value = '';
    document.forms[0].degree.value = '';
    document.forms[0].profession.value = '';
    document.forms[0].experience.value = '';
    document.forms[0].address.value = '';
    document.forms[0].dateOfBirth.value = '';
}

function validateCustomer()
{
    var name = document.forms[0].name.value;
    var degree = document.forms[0].degree.value;
    var exp = document.forms[0].experience.value;
    if (name === '')
    {
        alert("Please enter your name.");
        return false;
    }

    if (!isValidNumeric(exp))
    {
        alert("Please enter valid experience year & month.");
        return false;
    }
    return true;
}

function cancelCustomer()
{
    window.location.href = "show";
}


/////////////////////////////////////////////////////////////////////
////////////General Validation///////////////////////////////////////

function IsNumeric(input)
{
    var REXP = /^-{0,1}\d*\.{0,1}\d+$/;
    return (REXP.test(input));
}

function isValidNumeric(num)
{
    return !isNaN(parseFloat(num)) && isFinite(num);
}


////////////////////////////////////////////////
////Product validation/////////////////////////
///////////////////////////////////////////////

function  updateProduct()
{
    form = document.getElementById('product');
    form.action = 'update';
    form.submit();
}

function resetProduct()
{
    document.forms[0].name.value = '';
    document.forms[0].description.value = '';
    document.forms[0].quantity.value = '';
    document.forms[0].unitPrice.value = '';
    
}

function resetProductSearch()
{
    document.forms[0].name.value = '';
    document.forms[0].description.value = '';
    document.forms[0].unitPrice.value = '';
}

function cancelProduct()
{
    window.location.href = "show";
}

////////////////////////////////////////////////
////Order validation/////////////////////////
///////////////////////////////////////////////

function  updateOrder()
{
    form = document.getElementById('order');
    form.action = 'update';
    form.submit();
}
function resetOrder()
{
    document.forms[0].prodName.value = '';
    document.forms[0].quantity.value = '';
    document.forms[0].amount.value = '';
    document.forms[0].description.value = '';
}

function cancelOder()
{
    window.location.href = "show";
}