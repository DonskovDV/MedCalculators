const form = document.querySelector('#form');
const sendButton = document.querySelector('#Send');
let out = document.getElementById("title");
let out2 = document.getElementById("details");

const resetButton = document.querySelector('button[type="reset"]');

resetButton.addEventListener('click', function () {
    displayElement.textContent = "";
});



sendButton.addEventListener('click', () => {
    let height = document.getElementById("height_imt").value;
    let weight = document.getElementById("weight_imt").value;
    let h=document.getElementById("height_imt");
    let w=document.getElementById("weight_imt");
    h.style.borderColor="grey";
    w.style.borderColor="grey";
    let check = true;
    if (height.length==0 || weight.length==0)
     {
        check=false;
     }
    if(height>300 || height < 50)
    {
        h.style.borderColor="red";
        check=false;
    }
    if(weight<10)
    {
        w.style.borderColor="red";
        check=false;
    }
    if (check) {

    const data = {
        height,
        weight
    };
    $('#spinner-div').show();
    fetch('/calculator/IMT/result', {
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