let create_button = document.querySelector("#create_button");


let create_fetch = (contact) => {
    fetch('http://localhost:8080/phonebook/create', {
        method:'post',
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(contact)
    }).then(res => res.json())
    .then((data) => {
        card_creator(data.id, data.first_name, data.last_name, data.phone_number, data.email);
        console.log(`Request succeeded with JSON response ${data}`);
    })
    .catch((error) => console.log(`Request failed ${error}`))
}

let create_functionality = () => {
    if (first_name_input.value.length < 1 || phone_input.value.length < 1) {
        alert("Must enter first name and phone number");
        return;
    }
    let contact = new Object();
    contact["first_name"] = first_name_input.value;
    contact["phone_number"] = phone_input.value;
    if (last_name_input.value.length > 0) {
        contact["last_name"] = last_name_input.value;
    } else {
        contact["last_name"] = "";
    }
    if (email_input.value.length > 0){
        contact["email"] = email_input.value;
    } else {
        contact["email"] = "";
    }
    create_fetch(contact);
    reset();

}

create_button.addEventListener('click', create_functionality, false);