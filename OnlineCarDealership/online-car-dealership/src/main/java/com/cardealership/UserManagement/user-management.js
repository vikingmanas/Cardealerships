// Array to store users
let users = [];

// Function to validate the form and check if passwords match
function validateForm() {
    const username = document.getElementById('username').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();
    const confirmPassword = document.getElementById('confirmPassword').value.trim();

    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return false;
    }
    
    // Check if fields are empty
    if (!username || !email || !password) {
        alert("All fields are required!");
        return false;
    }

    return true;
}

// Function to handle form submission and adding user to the table
document.getElementById('userForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    if (!validateForm()) {
        return;
    }

    const username = document.getElementById('username').value.trim();
    const email = document.getElementById('email').value.trim();
    
    // Create a new user object
    const newUser = { username, email };

    // Add the user to the users array
    users.push(newUser);

    // Clear the form fields
    document.getElementById('userForm').reset();

    // Display the updated user list
    displayUsers();
});

// Function to display users in the table
function displayUsers() {
    const userTableBody = document.getElementById('userTableBody');
    userTableBody.innerHTML = '';

    users.forEach((user, index) => {
        const row = document.createElement('tr');
        
        const usernameCell = document.createElement('td');
        usernameCell.textContent = user.username;
        row.appendChild(usernameCell);

        const emailCell = document.createElement('td');
        emailCell.textContent = user.email;
        row.appendChild(emailCell);

        const actionsCell = document.createElement('td');
        actionsCell.innerHTML = `<button class="btn btn-danger" onclick="deleteUser(${index})">Delete</button>`;
        row.appendChild(actionsCell);

        userTableBody.appendChild(row);
    });
}

// Function to delete a user
function deleteUser(index) {
    users.splice(index, 1);
    displayUsers();
}
