let update_button = document.querySelector("#update_button");


let update_fetch = (type,id,_content) => {
    fetch(`http://localhost:8080/phonebook/update/${type}/${id}`, {
    method:'PATCH',
    headers:{
        "Content-type": "application/json",
    },
    body: _content
}).then(res => res.json())
.then((data) => {
    card_creator(data.id, data.first_name, data.last_name, data.phone_number, data.email);
})
.catch((error) => console.log(`Request failed ${error}`));
}



let update_functionality = () => {
    let id_ = id_input.value;
    let first = first_name_input.value;
    let last = last_name_input.value;
    let phone = phone_input;
    let email = email_input.value;

    alert('This will only update one field per click (priority - first name -> last name -> phone number -> email');

    if (id_ < 1) {
        alert("Please input ID for contact you want to update");
        return;
    }
    if (first.length > 0){
        clear_results();
        update_fetch('first-name', id_, first);
        console.log("got here");
    }
    else if (last.length > 0){
        clear_results();
        update_fetch('last-name', id_, last);
        console.log("got here");
    }
    else if (phone.length > 0){
        clear_results();
        update_fetch('phone', id_, phone);
        console.log("got here");
    }
    else if (email.length > 0){
        clear_results();
        update_fetch('email', id_, email);
        console.log("got here");
    }

    reset();
}

update_button.addEventListener('click', update_functionality, false);
