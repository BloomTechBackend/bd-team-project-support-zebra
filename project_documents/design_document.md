# [team name] Design Document
# Modules
*Authentication
*Registration
*Email Verification
*Profile
*Messaging
- Search a user
- Search within conversation
- Block / Unblock
- Attachment
- CRUD
- 
*Service Provider - Future (For company, manage Personnel) 
  - Manage Payment(e-wallet)
  - Manage Services  
  - Reports (Income, Performance, Client, Re-occurrence)
  - Remarks(optional)
  - Booking Calendar (Manual)
  - Notification (Appointment for approval, re-schedule)
  - Service Quotation (save as draft)
  - Location

*Customer
  - Manage Payment (e-wallet)
  - Manage Booking
    - Upcoming appointment (Cancel, Reschedule)
    - Cancelled appointment (Re-use)
    - Past appointment (Re-use)
    - Ongoing
    - Re-schedule 
      
  - List of Service Providers (per SP)
    - Profile (Landing page)
      - Message
      - Reviews
      - About
      - Contact us
      - List of Services (with quotation)
      - CTA (Call to Action)
        - Avail Service
          - Booking Calendar(displays availability)
          - Property Location
    - Performance Review / feedback (star & remarks)
*Admin
 - Review approval
 - Manage Service Provider
 - Manage Customer
 - Reports (List of SP, Customer, Income, Low Reviews SP, Billing)
## Instructions

*Save a copy of this template for your team in the same folder that contains
this template.*

*Replace italicized text (including this text!) with details of the design you
are proposing for your team project. (Your replacement text shouldn't be in
italics)*

*You should take a look at the example design document in the same folder as
this template for more guidance on the types of information to capture, and the
level of detail to aim for.*

## *Project Title* Design

## 1. Problem Statement

* Service provider online presence
* Decentralized service providers
* Performance review
  * Customer relies on network of people for the job with biased review.
  * No output can validate the quality of work.
* Indecisive availability
* Uncertain service cost



## 2. Top Questions to Resolve in Review

*List the most important questions you have about your design, or things that
you are still debating internally that you might like help working through.*

1. Booking Payment
2. Booking Process(Startpoint to Endpoint)
3. Manage personnel for Service Provider (Company)

## 3. Use Cases

*This is where we work backwards from the customer and define what our customers
would like to do (and why). You may also include use cases for yourselves, or
for the organization providing the product to customers.*

Manage Services
CRUD Service
Manage Cost/Service()

Bookings(Calendar)
Calendar(show available date) on Manage Serices
Show Calendar with bookings(change view to specific date, by week, by month)
both customer and SP(show appoinments upcoming, pending, past, cancelled)

Messsaging
Send Message
Attachments
Search individual and view Profile(show button "send a message" show "block/unblock")

Signup > Email Verification > Create Profile

As Customer > I want to Signup > when I provide Email as Username and password
As Customer > I want to Login > When I provide Username and password
As Customer > I want to Create a Profile
As Customer > I want to Retrieve specific service
As Customer > I want to Create a message SP
As Customer > I want to Create a review to a service
As Customer > I want to Create an Appointment
As Customer > I want to Update Appointment
As Customer > I want to View SP availability while booking
As Customer > I want to view SP services
As Customer > I want to view Service Cost and Reviews
As Customer > I want to view service provider portfolio
As Customer > I want to view > Upcoming appointment > When I log in to dashboard
As Customer > I want to view available services
As Customer > I want to view Ongoing Appointment
As Customer > I want to view upcoming Appointment
As Customer > I want to view Appointment History















As SP > I want to Signup > when I provide Email as Username and password
As SP > I want to Login > When I provide Username and password
As SP > I want to Create a Profile
As SP > I want to create a service
As SP > I want to Update a service
As SP > I want to retrieve list of services
As SP > I want to view reviews/service
As SP > I want to view > Upcoming appointment > When I log in to dashboard
As SP > I want to view booking Calendar
As SP > I want to view Ongoing Appointment
As SP > I want to view upcoming Appointment
As SP > I want to view Appointment History
As SP > I want to create Service cost
As SP > I want to Update Service cost

As Admin > I want to create new SP
As Admin > I want to retrieve list of SPs
As Admin > I want to retrieve list of Customers
As Admin > I want to delete SP
As Admin > I want to delete Customer
As Admin > I want to update SP
As Admin > I want to view low reviews SP
As Admin > I want to approve SP
As Admin > I want to approve Reviews
As Admin > I want to retrieve list of services
As Admin > I want to view reviews per service
As Admin > I want to view > Upcoming appointment per SP and Customer
As Admin > I want to view booking Calendar per SP and Customer
As Admin > I want to view Ongoing Appointment per SP and Customer
As Admin > I want to view upcoming Appointment per SP and Customer
As Admin > I want to view Appointment History per SP and Customer
As Admin > I want to view Service cost per SP





## 4. Project Scope

*Clarify which parts of the problem you intend to solve. It helps reviewers know
what questions to ask to make sure you are solving for what you say and stops
discussions from getting sidetracked by aspects you do not intend to handle in
your design.*

### 4.1. In Scope

*Which parts of the problem defined in Sections 1 and 3 will you solve with this
design?*

### 4.2. Out of Scope

*Based on your problem description in Sections 1 and 3, are there any aspects
you are not planning to solve? Do potential expansions or related problems occur
to you that you want to explicitly say you are not worrying about now? Feel free
to put anything here that you think your team can't accomplish in the unit, but
would love to do with more time.*

# 5. Proposed Architecture Overview

*Describe broadly how you are proposing to solve for the requirements you
described in Section 3.*

*This may include class diagram(s) showing what components you are planning to
build.*

*You should argue why this architecture (organization of components) is
reasonable. That is, why it represents a good data flow and a good separation of
concerns. Where applicable, argue why this architecture satisfies the stated
requirements.*

# 6. API

## 6.1. Public Models

*Define the data models your service will expose in its responses via your
*`-Model`* package. These will be equivalent to the *`PlaylistModel`* and
*`SongModel`* from the Unit 3 project.*

## 6.2. *First Endpoint*

*Describe the behavior of the first endpoint you will build into your service
API. This should include what data it requires, what data it returns, and how it
will handle any known failure cases. You should also include a sequence diagram
showing how a user interaction goes from user to website to service to database,
and back. This first endpoint can serve as a template for subsequent endpoints.
(If there is a significant difference on a subsequent endpoint, review that with
your team before building it!)*

*(You should have a separate section for each of the endpoints you are expecting
to build...)*

## 6.3 *Second Endpoint*

*(repeat, but you can use shorthand here, indicating what is different, likely
primarily the data in/out and error conditions. If the sequence diagram is
nearly identical, you can say in a few words how it is the same/different from
the first endpoint)*

# 7. Tables

*Define the DynamoDB tables you will need for the data your service will use. It
may be helpful to first think of what objects your service will need, then
translate that to a table structure, like with the *`Playlist` POJO* versus the
`playlists` table in the Unit 3 project.*

# 8. Pages

*Include mock-ups of the web pages you expect to build. These can be as
sophisticated as mockups/wireframes using drawing software, or as simple as
hand-drawn pictures that represent the key customer-facing components of the
pages. It should be clear what the interactions will be on the page, especially
where customers enter and submit data. You may want to accompany the mockups
with some description of behaviors of the page (e.g. “When customer submits the
submit-dog-photo button, the customer is sent to the doggie detail page”)*
