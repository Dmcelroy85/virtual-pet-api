# Virtual Pet API

IMPORTANT: Please refer to the course in Instructure Canvas for project full requirements

Now we will take Virtual pet to its logical conclusion! A fully functional MVC application! Your team will choose one of your virtual pet applications and transform it into a backend application with a functional front end! This will test everything you’ve learned up until this point, and will also be your first group project.

## Required Tasks

### Backend

- Choose which student’s virtual pet will be used for this project.
- Use the Virtual Pet classes from Virtual Pet Amok as your model. This will probably require substantial modifications, that’s what the team is for!
- Relate Shelter to Virtual Pet. Allow for more than one shelter, though you still only need one shelter unless you want to get fancy.
- Make appropriate repos for your model.
- Make controller endpoints that can do everything your original pets did in Amok. For instance, make an endpoint that will feed all your pets. Make sure you still tick() when you should!

### Frontend

- Create a frontend that has the following pages:
  - Shelter view which shows the names and basic stats of a pet. Also should allow you to adopt pets out and call appropriate shelter methods.
  - Pet view which shows a pet in detail. Also should be capable of running any pet specific methods you have.
  - Add pet view which allows you to add a new pet. Feel free to incorporate this one directly into the shelter view or pet view if you think it looks better.
- Use CSS styling and keep a consistent styling throughout the frontend.
- Use Javascript to interact with your back end.

#### Stretch Tasks

Animation:
Add Javascript animations to the view.

Make your pets tick in real time:
Make it so that rather than calling tick() every time you interact with your shelter, tick() gets called every few seconds and updates the view.

Use your creativity:
If you think of something and have extra time, feel free to attempt it!
