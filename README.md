# PC Recommendation System
> A Java Enterprise Website to help you build the PC of your dreams without hassle. This system allows non-technical users to recommend the best customised parts and components for their PC. The system uses various algorithms to determine the compatibility among parts, optimal performance combination among them and provide Amazon links for easy purchase based on customer budget and needs.


## Development and Usage

Clone the repo and deploy it on any PaaS (heroku recommended). You might want to add *your own postres implementation*.
> The project has implemented MVC Development, The structure hence is divided into core modules, presentation, and the data objects. The system is hosted on Heroku EU region with the standard Dyno formation along with a postgreSQL service add-on which acts as the primary Database for the system. A single Connection Provider handles the data access of entire system, DAO(Data Access Objects) of their respective modules are given flexibility to fetch and update DB accordingly. PCBuilder allows the system to check for the compatibility and generate a recommendation set of optimal components, Product Tracker periodically fetches the price data and updates the details into the database. Session Manager handles all the operations concerning logged in users. Various Servlets are used to carry out intractive tasks like logging in and out of the system,changing profile details, browsing through the system, registration, Admin with special privileges can add new products right from the system. 


## Release History


* 0.0.1
    * Work in progress ***https://pc-recommendation-system.herokuapp.com***


## Meta

Sahaj Dave – 201912103@daiict.ac.in

Distributed under the MIT license. See ``LICENSE`` for more information.

[https://github.com/davesahaj/](https://github.com/davesahaj/)


## Contributing

1. Fork it (<https://github.com/yourname/yourproject/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request

