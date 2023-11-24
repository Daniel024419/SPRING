# SPRING



<!-- Routes -->
users
api/users
-fetch-users
-save-user
-delete-user?_id=${_id}
-update-user
-search-users-with-id?=${_id}

//service files
files/fetch-files?filename=${filename}



//delet response
/api/users/delete-user?_id=${_id}

//fetch files
/files/fetch-files?filename=${filename}

/users/search-users-with-id?_id=${_id}


    //save user body
    	{
		"username": "Marcus Eshun",
		"location": "Kumasi",
		"profile": "kk.jpg",
        tel:"08228288222",
		"password": "k22",
		"usermail": "eshun@gmail.com",
		"createdAt": "2023-03-10T00:00:00.000+00:00",
		"updatedAt": "2021-02-10T22:00:00.000+00:00"
	}


//heroku cmd
  
  logs system errors
  heroku logs --tail -a your-app-name
  heroku logs --tail -a mvc-0.1

  //add configuration
  heroku config:set var_name=value


  //res / req codes

  error 400- bad req / 500 / 501 - internal err

  good 200-299
   

   //verify pass

   // Example: Verifying a password
        String enteredPassword = "user123"; // This is what the user entered during login
        boolean isPasswordCorrect = checkPassword(enteredPassword, hashedPassword);

        if (isPasswordCorrect) {
            System.out.println("Password is correct!");
        } else {
            System.out.println("Password is incorrect.");
        }



//fun to check

    // Check if the entered password matches the hashed password
    private static boolean checkPassword(String enteredPassword, String hashedPassword) {
        return BCrypt.checkpw(enteredPassword, hashedPassword);
    }