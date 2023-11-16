# SPRING



<!-- Routes -->
users
api/users
-fetch-users
-save-user
-delete-user
-update-user


//handle res from the server to client
  .then(response => {
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }
    return response.json();
  })
  .then(data => {
    // Handle successful response (data contains the saved user object)
    console.log('User saved:', data);
  })
  .catch(error => {
    // Handle error response (error.message contains the error message)
    console.error('Error saving user:', error.message);
  });

  //delet response
  const userId = "123"; // Replace with the actual user ID
    fetch(`/api/users/delete-user?_id=${_id}`, {
        method: 'DELETE',
    })


    //save user body
    	{
		"username": "Marcus Eshun",
		"location": "Kumasi",
		"profile": "kk.jpg",
		"password": "k22",
		"usermail": "eshun@gmail.com",
		"createdAt": "2023-03-10T00:00:00.000+00:00",
		"updatedAt": "2021-02-10T22:00:00.000+00:00"
	}