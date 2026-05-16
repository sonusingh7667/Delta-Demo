
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            width: 450px;
            margin: 40px auto;
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
        }

        h2 {
            text-align: center;
            color: darkblue;
        }

        label {
            font-weight: bold;
        }

        input, textarea {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
        }

        .gender {
            width: auto;
        }

        .buttons {
            text-align: center;
        }

        button {
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
        }
    </style>
</head>

<body>

    <div class="container">
        <h2>Presidency University Student Registration</h2>

        <form onsubmit="return validateForm()">

            <label>First Name:</label>
            <input type="text" id="fname">

            <label>Last Name:</label>
            <input type="text" id="lname">

            <label>Email ID:</label>
            <input type="text" id="email">

            <label>Password:</label>
            <input type="password" id="password">

            <label>Address:</label>
            <textarea id="address"></textarea>

            <label>Mobile Number:</label>
            <input type="text" id="mobile">

            <label>Gender:</label><br>

            <input type="radio" name="gender" class="gender"> Male
            <input type="radio" name="gender" class="gender"> Female
            <input type="radio" name="gender" class="gender"> Other

            <br><br>

            <div class="buttons">
                <button type="submit">Submit</button>
                <button type="reset">Cancel</button>
            </div>

        </form>
    </div>

    <script>

        function validateForm() {

            let fname = document.getElementById("fname").value;
            let lname = document.getElementById("lname").value;
            let email = document.getElementById("email").value;
            let password = document.getElementById("password").value;
            let address = document.getElementById("address").value;
            let mobile = document.getElementById("mobile").value;

            if(fname == ""){
                alert("First Name should not be empty");
                return false;
            }

            if(lname == ""){
                alert("Last Name should not be empty");
                return false;
            }

            if(email == ""){
                alert("Email should not be empty");
                return false;
            }

            if(password == ""){
                alert("Password should not be empty");
                return false;
            }

            if(address == ""){
                alert("Address should not be empty");
                return false;
            }

            if(mobile == ""){
                alert("Mobile Number should not be empty");
                return false;
            }

            alert("Registration done successfully");

        }

    </script>

</body>
</html>

//////////////////////////////////////////////////////////////////






<!-- <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RSVP Form</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

    <div class="container mt-5">
        
        <div class="card shadow p-4">
            
            <h2 class="text-center mb-4">RSVP Event Form</h2>

            <form class="needs-validation" novalidate>

                <div class="row">

                    <!-- First Name -->
                    <div class="col-md-6 mb-3">
                        <label class="form-label">First Name</label>
                        <input type="text" class="form-control" required>
                        <div class="invalid-feedback">
                            Please enter first name.
                        </div>
                    </div>

                    <!-- Last Name -->
                    <div class="col-md-6 mb-3">
                        <label class="form-label">Last Name</label>
                        <input type="text" class="form-control" required>
                        <div class="invalid-feedback">
                            Please enter last name.
                        </div>
                    </div>

                </div>

                <!-- Email -->
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" class="form-control" required>
                    <div class="invalid-feedback">
                        Please enter valid email.
                    </div>
                </div>

                <!-- Phone -->
                <div class="mb-3">
                    <label class="form-label">Phone Number</label>
                    <input type="tel" class="form-control" required>
                    <div class="invalid-feedback">
                        Please enter phone number.
                    </div>
                </div>

                <div class="row">

                    <!-- Country -->
                    <div class="col-md-4 mb-3">
                        <label class="form-label">Country</label>
                        <input type="text" class="form-control" required>
                        <div class="invalid-feedback">
                            Please enter country.
                        </div>
                    </div>

                    <!-- State -->
                    <div class="col-md-4 mb-3">
                        <label class="form-label">State</label>
                        <input type="text" class="form-control" required>
                        <div class="invalid-feedback">
                            Please enter state.
                        </div>
                    </div>

                    <!-- Zip -->
                    <div class="col-md-4 mb-3">
                        <label class="form-label">Zip Code</label>
                        <input type="text" class="form-control" required>
                        <div class="invalid-feedback">
                            Please enter zip code.
                        </div>
                    </div>

                </div>

                <!-- Additional Information -->
                <div class="mb-3">
                    <label class="form-label">Additional Information</label>
                    <textarea class="form-control" rows="4" placeholder="Enter event details or guest information"></textarea>
                </div>

                <!-- Submit Button -->
                <div class="text-center">
                    <button class="btn btn-primary" type="submit">
                        Submit RSVP
                    </button>
                </div>

            </form>

        </div>

    </div>

    <!-- Bootstrap Validation Script -->
    <script>

        (() => {
            'use strict'

            const forms = document.querySelectorAll('.needs-validation')

            Array.from(forms).forEach(form => {

                form.addEventListener('submit', event => {

                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')  

                }, false)

            })

        })()

    </script>

</body>
</html> 




//////////////////////////////////////////////





<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>jQuery Fading Effects</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

    <style>

        body{
            background-color: #f2f2f2;
        }

        .box{
            padding: 20px;
            margin: 15px;
            border-radius: 10px;
            text-align: center;
            color: white;
            font-size: 20px;
        }

        .box1{
            background-color: crimson;
        }

        .box2{
            background-color: royalblue;
        }

        .box3{
            background-color: seagreen;
        }

        img{
            width: 100%;
            max-width: 300px;
            height: 200px;
            border-radius: 10px;
        }

    </style>

</head>

<body>

    <div class="container mt-5">

        <div class="card shadow p-4">

            <h2 class="text-center mb-4">
                jQuery Fade Effects Demo
            </h2>

            <!-- Buttons -->

            <div class="text-center mb-4">

                <button class="btn btn-success m-2" id="fadeInBtn">
                    Fade In
                </button>

                <button class="btn btn-danger m-2" id="fadeOutBtn">
                    Fade Out
                </button>

                <button class="btn btn-primary m-2" id="fadeToggleBtn">
                    Fade Toggle
                </button>

            </div>

            <!-- Elements -->

            <div class="row">

                <div class="col-md-4">
                    <div class="box box1" id="textBox">
                        Welcome to jQuery
                    </div>
                </div>

                <div class="col-md-4 text-center">
                    <img src="https://picsum.photos/300/200"
                         id="imageBox"
                         alt="Sample Image">
                </div>

                <div class="col-md-4 text-center">

                    <button class="btn btn-warning mt-5"
                            id="sampleButton">
                        Sample Button
                    </button>

                </div>

            </div>

        </div>

    </div>

    <script>

        $(document).ready(function(){

            // Fade In

            $("#fadeInBtn").click(function(){

                $("#textBox").fadeIn(1000);
                $("#imageBox").fadeIn(1500);
                $("#sampleButton").fadeIn(2000);

            });

            // Fade Out

            $("#fadeOutBtn").click(function(){

                $("#textBox").fadeOut(1000);
                $("#imageBox").fadeOut(1500);
                $("#sampleButton").fadeOut(2000);

            });

            // Fade Toggle

            $("#fadeToggleBtn").click(function(){

                $("#textBox").fadeToggle(1000);
                $("#imageBox").fadeToggle(1500);
                $("#sampleButton").fadeToggle(2000);

            });

        });

    </script>

</body>
</html>


/////////////////////////////////////////////


<!DOCTYPE html>
<html lang="en" ng-app="planetApp">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Planet Information</title>

    <!-- AngularJS CDN -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body ng-controller="planetController" class="bg-light">

    <div class="container mt-5">

        <div class="card shadow p-4">

            <h2 class="text-center mb-4">
                Planet Information Table
            </h2>

            <!-- Search Box -->
            <div class="mb-3">
                <label class="form-label">Search Planet</label>
                <input type="text"
                       class="form-control"
                       placeholder="Search here..."
                       ng-model="searchText">
            </div>

            <!-- Sort Dropdown -->
            <div class="mb-4">
                <label class="form-label">Sort By</label>

                <select class="form-select" ng-model="sortColumn">

                    <option value="name">Name</option>
                    <option value="type">Type</option>
                    <option value="distance">Distance from Sun</option>
                    <option value="moons">Number of Moons</option>

                </select>
            </div>

            <!-- Table -->
            <table class="table table-bordered table-striped text-center">

                <thead class="table-dark">
                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Distance from Sun</th>
                        <th>Number of Moons</th>
                    </tr>
                </thead>

                <tbody>

                    <tr ng-repeat="planet in planets | filter:searchText | orderBy:sortColumn">

                        <td>{{planet.name}}</td>
                        <td>{{planet.type}}</td>
                        <td>{{planet.distance}}</td>
                        <td>{{planet.moons}}</td>

                    </tr>

                </tbody>

            </table>

        </div>

    </div>

    <script>

        var app = angular.module("planetApp", []);

        app.controller("planetController", function($scope) {

            $scope.planets = [

                {
                    name: "Mercury",
                    type: "Terrestrial",
                    distance: 57.9,
                    moons: 0
                },

                {
                    name: "Venus",
                    type: "Terrestrial",
                    distance: 108.2,
                    moons: 0
                },

                {
                    name: "Earth",
                    type: "Terrestrial",
                    distance: 149.6,
                    moons: 1
                },

                {
                    name: "Mars",
                    type: "Terrestrial",
                    distance: 227.9,
                    moons: 2
                },

                {
                    name: "Jupiter",
                    type: "Gas Giant",
                    distance: 778.5,
                    moons: 95
                },

                {
                    name: "Saturn",
                    type: "Gas Giant",
                    distance: 1433.5,
                    moons: 146
                },

                {
                    name: "Uranus",
                    type: "Ice Giant",
                    distance: 2872.5,
                    moons: 27
                },

                {
                    name: "Neptune",
                    type: "Ice Giant",
                    distance: 4495.1,
                    moons: 14
                }

            ];

            $scope.sortColumn = "name";

        });

    </script>

</body>
</html>





//////////////////////////////////////


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Responsive Image Grid</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>

        body{
            background-color: #f2f2f2;
        }

        img{
            width: 100%;
            height: 250px;
            object-fit: cover;
            border-radius: 10px;
        }

        .image-box{
            margin-bottom: 20px;
        }

    </style>

</head>

<body>

    <div class="container mt-5">

        <h2 class="text-center mb-4">
            Bootstrap 5 Responsive Image Grid
        </h2>

        <div class="row">

            <!-- Image 1 -->
            <div class="col-sm-6 col-md-4 col-lg-3 image-box">

                <img src="https://picsum.photos/id/1015/400/300"
                     alt="Image 1">

            </div>

            <!-- Image 2 -->
            <div class="col-sm-6 col-md-4 col-lg-3 image-box">

                <img src="https://picsum.photos/id/1016/400/300"
                     alt="Image 2">

            </div>

            <!-- Image 3 -->
            <div class="col-sm-6 col-md-4 col-lg-3 image-box">

                <img src="https://picsum.photos/id/1018/400/300"
                     alt="Image 3">

            </div>

            <!-- Image 4 -->
            <div class="col-sm-6 col-md-4 col-lg-3 image-box">

                <img src="https://picsum.photos/id/1020/400/300"
                     alt="Image 4">

            </div>

            <!-- Image 5 -->
            <div class="col-sm-6 col-md-4 col-lg-3 image-box">

                <img src="https://picsum.photos/id/1024/400/300"
                     alt="Image 5">

            </div>

            <!-- Image 6 -->
            <div class="col-sm-6 col-md-4 col-lg-3 image-box">

                <img src="https://picsum.photos/id/1025/400/300"
                     alt="Image 6">

            </div>

            <!-- Image 7 -->
            <div class="col-sm-6 col-md-4 col-lg-3 image-box">

                <img src="https://picsum.photos/id/1035/400/300"
                     alt="Image 7">

            </div>

            <!-- Image 8 -->
            <div class="col-sm-6 col-md-4 col-lg-3 image-box">

                <img src="https://picsum.photos/id/1040/400/300"
                     alt="Image 8">

            </div>

        </div>

    </div>

</body>
</html>
