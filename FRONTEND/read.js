let search_button = document.querySelector("#search_button");
let view_button = document.querySelector("#view_button");


let readAll_fetch = () => {
    fetch('http://localhost:8080/phonebook/readAll')
    .then((response) => {
    if (response.status !== 200) {
        console.log(`status: ${response.status}`);
        return;
    }
    response.json()
    .then(data => {
        for (let i of data){
            card_creator(i.id, i.first_name, i.last_name, i.phone_number, i.email);
        }
    })}).catch((err) => console.error(`${err}`));
}


let readAll_functionality = () => {
    readAll_fetch();
}

let read_fetch = (type, param) => {
    fetch(`http://localhost:8080/phonebook/read/${type}/${param}`)
    .then((response) => {
        if (response.status !==200){
            console.log(`status: ${response.status}`);
            return;
        }
        response.json()
        .then(data => {
            if (type !== 'name'){
                card_creator(data.id, data.first_name, data.last_name, data.phone_number, data.email);
            } else {
                for (let i of data) {
                    card_creator(i.id, i.first_name, i.last_name, i.phone_number, i.email);
                }
            }
        })
    }).catch((err) => console.error(`${err}`));
}


let read_functionality = () => {
    if (id_input.value > 1) {
        read_fetch('id', id_input.value);
    } else {
        if (first_name_input.value.length > 0){
            read_fetch('name', first_name_input.value);
        }
        if (last_name_input.value.length > 0){
            read_fetch('name', last_name_input.value);
        }
        if (phone_input.value.length > 0){
            read_fetch('phone', phone_input.value);
        }
        if (email_input.value.length > 0){
            read_fetch('email', email_input.value);
        }
    }

    reset();
}

search_button.addEventListener('click', read_functionality, false);
view_button.addEventListener('click', readAll_functionality, false);