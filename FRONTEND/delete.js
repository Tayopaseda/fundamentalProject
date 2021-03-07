let delete_button = document.querySelector("#delete_button");


let delete_fetch = (id) => {
    fetch(`http://localhost:8080/phonebook/delete/${id}`, {
        method:'delete'
    })
    .then((data) => {
        console.log(`Request succeeded with JSON response ${data}`);
        alert("Contact Deleted!");
    }).catch((error) => console.log(`Request failed ${error}`));
}

let delete_functionality = () => {
    if (id_input.value <1){
        alert("Please enter id of contact to be deleted");
        return;
    }
    delete_fetch(id_input.value);

    reset();
}

delete_button.addEventListener('click', delete_functionality, false);