const form = document.querySelector('#form');
const sendButton = document.querySelector('#Send');
let out = document.getElementById("title");
let out2 = document.getElementById("details");
let fio_switch_a = document.getElementById('fio>=0.5');
let fio_switch_b = document.getElementById('fio<0.5');

const resetButton = document.querySelector('button[type="reset"]');

resetButton.addEventListener('click', function () {
    location.reload();
});

document.addEventListener("DOMContentLoaded",hiddenCloseclick());
document.getElementById('blood_gas_switch').addEventListener("click", hiddenCloseclick);
	function hiddenCloseclick() {
	let y = document.getElementById('gas_yes');
	let x = document.getElementById('gas_no');
      if (x.style.display == "none"){
	    x.style.display = "block";
	    y.style.display = "none"
	  }
	  else
	  {
	     x.style.display = "none"
	     y.style.display = "block";
	     fio_switch_a.style.display = "none";
	     fio_switch_b.style.display = "block";
	  }
    };

//document.addEventListener("DOMContentLoaded", hiddenCloseClick());
document.getElementById('FiO2_switch').addEventListener("click", hiddenCloseClick);
	function hiddenCloseClick() {
	let x = document.getElementById('fio<0.5');
	let y = document.getElementById('fio>=0.5');

      if (x.style.display == "none"){
	    x.style.display = "block";
	    y.style.display = "none"
	  }
	  else
	  {
	     x.style.display = "none"
	     y.style.display = "block";
	  }
    };


sendButton.addEventListener('click', () => {
    let disfunction=document.getElementById("disfunction_apache").value;
    let renal_failure=document.getElementById("renal_failure_apache").value;
    let age = document.getElementById("age_apache").value;
    let rectal_temp=document.getElementById("rectal_temp_apache").value;
    let avg_blood_pressure=document.getElementById("avg_blood_pressure_apache").value;
    let heart_rate=document.getElementById("heart_rate_apache").value;
    let breath_rate=document.getElementById("breath_rate_apache").value;
    let serum_sodium=document.getElementById("serum_sodium_apache").value;
    let serum_potassium=document.getElementById("serum_potassium_apache").value;
    let serum_creatinine=document.getElementById("serum_creatinine_apache").value;
    let hematocrit=document.getElementById("hematocrit_apache").value;
    let leuko=document.getElementById("leuko_apache").value;
    let glasgow=document.getElementById("glasgow_apache").value;
    let check = true;
    if (disfunction.length==0 || renal_failure.length==0 || age.length==0 || rectal_temp.length==0 ||
    avg_blood_pressure.length==0 || heart_rate.length==0 || breath_rate.length==0 ||
    serum_sodium.length==0 || serum_potassium.length==0 || serum_creatinine.length==0 ||
    hematocrit.length==0 || leuko.length==0 || glasgow.length==0) check=false;

    if (check) {
     const data = {
             disfunction,
             renal_failure,
             age,
             rectal_temp,
             avg_blood_pressure,
             heart_rate,
             breath_rate,
             serum_sodium,
             serum_potassium,
             serum_creatinine,
             hematocrit,
             leuko,
             glasgow,
             bicarbonate: document.getElementById("bicarbonate_apache").value,
             pH: document.getElementById("pH_apache").value,
             paO2: document.getElementById("PaO2_apache").value,
             a_a_gradient: document.getElementById("gradient_apache").value

     };


    $('#spinner-div').show();  //до сюда не доходит пока не получит data
    fetch('/calculator/ApacheII/result', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if(response.ok){
                return  response.json()
            }else {
                throw new Error('Ошибка HTTP: ' + response.status);
            }
        })
        .then(result => {
            setTimeout(() => {
                out.textContent = result.title || "";
                out2.textContent = result.details || "";
                $('#spinner-div').hide();
            }, 500);
        })
        .catch(error => {
            out.textContent=(error);
            setTimeout(() => {
                $('#spinner-div').hide();
            }, 500);
        });
    }
});

form.addEventListener('submit', (event) => {
    event.preventDefault();
    sendButton.click();
});