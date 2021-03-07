'use strict';
let id_input = document.querySelector("#id_input");
let first_name_input = document.querySelector("#first_name_input");
let last_name_input = document.querySelector("#last_name_input");
let phone_input = document.querySelector("#phone_input");
let email_input = document.querySelector("#email_input");
let result_list = document.querySelector("#results");

let button_div = document.querySelector("#button_div");
let reset_inputs = document.querySelector("#reset_inputs");

let num_of_results = 0;

let card_creator = (id, first, last, phone, email) => {
    let col = document.createElement("div");
    col.setAttribute('class', 'col');
    let card = document.createElement("div");
    card.setAttribute('class', 'card h-100 text-black bg-danger');
    let card_body = document.createElement("div");
    card_body.setAttribute('class', 'card-body');
    let card_title = document.createElement("h5");
    card_title.innerHTML = `${first} ${last}`;
    let id_no = document.createElement("p");
    id_no.innerHTML = `ID: ${id}`;
    let phone_details = document.createElement("p");
    phone_details.innerHTML = `Phone number: ${phone}`;
    let email_details = document.createElement("p");
    email_details.innerHTML = `Email: ${email}`;
    card_body.appendChild(card_title);
    card_body.appendChild(id_no)
    card_body.appendChild(phone_details);
    card_body.appendChild(email_details);
    card.appendChild(card_body);
    col.appendChild(card);
    result_list.appendChild(col);
    num_of_results++;
}

let clear_results = () => {
    if (num_of_results===0){
        return;
    } 
    for (let i = 0; i<num_of_results; i++){ 
        let div = document.querySelector("#results > div");
        result_list.removeChild(div);
    }
    num_of_results = 0;
}

let reset = () => {
    id_input.value = 0;
    first_name_input.value = "";
    last_name_input.value = "";
    phone_input.value = "";
    email_input.value = "";
}


button_div.addEventListener('click', clear_results);
