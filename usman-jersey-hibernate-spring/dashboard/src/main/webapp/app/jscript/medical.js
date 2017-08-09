/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function  updateDoctor()
{
    form = document.getElementById('doctor');
    form.action = 'update';
    form.submit();
}
function resetDoctor()
{
    document.forms[0].name.value = '';
    document.forms[0].degree.value = '';
    document.forms[0].profession.value = '';
    document.forms[0].experience.value = '';
    document.forms[0].address.value = '';
    document.forms[0].dateOfBirth.value = '';
}

function validateDoctor()
{
    var name = document.forms[0].name.value;
    var degree = document.forms[0].degree.value;
    var exp = document.forms[0].experience.value;
    if (name === '')
    {
        alert("Please enter your name.");
        return false;
    }
    if (degree === '')
    {
        alert("Please enter your degree.");
        return false;
    }

    if (!isValidNumeric(exp))
    {
        alert("Please enter valid experience year & month.");
        return false;
    }
    return true;
}

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
////Patinet validation/////////////////////////
///////////////////////////////////////////////

function  updatePatient()
{
    form = document.getElementById('patient');
    form.action = 'update';
    form.submit();
}

function resetPatient()
{
    document.forms[0].name.value = '';
    document.forms[0].age.value = '';
    document.forms[0].address.value = '';
    document.forms[0].phone.value = '';
    document.forms[0].email.value = '';
}

function resetPatientSearch()
{
    document.forms[0].moduleId.value = '';
    document.forms[0].name.value = '';
    document.forms[0].address.value = '';
    document.forms[0].phone.value = '';
}

////////////////////////////////////////////////
////Payment validation/////////////////////////
///////////////////////////////////////////////

function  updatePayment()
{
    form = document.getElementById('payment');
    form.action = 'update';
    form.submit();
}
function resetPayment()
{
    document.forms[0].feeType.value = '';
    document.forms[0].amount.value = '';
    document.forms[0].department.value = '';
    document.forms[0].doctorId.value = '';
    document.forms[0].description.value = '';
}