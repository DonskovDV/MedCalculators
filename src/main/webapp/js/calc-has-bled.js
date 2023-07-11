const form = document.querySelector('#form');
const sendButton = document.querySelector('#Send');
let out = document.getElementById("title");
let out2 = document.getElementById("details");

let check1_has = document.getElementById("check1_has");
let check2_has = document.getElementById("check2_has");
let check3_has = document.getElementById("check3_has");
let check4_has = document.getElementById("check4_has");
let check5_has = document.getElementById("check5_has");
let check6_has = document.getElementById("check6_has");
let check7_has = document.getElementById("check7_has");
let check8_has = document.getElementById("check8_has");
let check9_has = document.getElementById("check9_has");


const resetButton = document.querySelector('button[type="reset"]');

resetButton.addEventListener('click', function () {
    displayElement.textContent = "";
});

sendButton.addEventListener('click', () => {
    let check1 = 0;
    let check2 = 0;
    let check3 = 0;
    let check4 = 0;
    let check5 = 0;
    let check6 = 0;
    let check7 = 0;
    let check8 = 0;
    let check9 = 0;

    if (check1_has.checked) {
        check1 = "1";
    }
    if (check2_has.checked) {
        check2 = "1";
    }
    if (check3_has.checked) {
        check3 = "1";
    }
    if (check4_has.checked) {
        check4 = "1";
    }
    if (check5_has.checked) {
        check5 = "1";
    }
     if (check6_has.checked) {
         check6 = "1";
     }
     if (check7_has.checked) {
        check7 = "1";
     }
     if (check8_has.checked) {
        check8 = "1";
     }
     if (check9_has.checked) {
        check9 = "1";
     }

    const data = {
        check1:check1,
        check2:check2,
        check3:check3,
        check4:check4,
        check5:check5,
        check6:check6,
        check7:check7,
        check8:check8,
        check9:check9
    };
    $('#spinner-div').show();
    fetch('/calculator/HasBled/result', {
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
});

form.addEventListener('submit', (event) => {
    event.preventDefault();
    sendButton.click();
});