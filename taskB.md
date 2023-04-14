## Overview

[Use Case Flow for Task B](#use-case-flow-for-task-b) (includes screenshots of execution of the application with sample input/output)

### Use Case Flow for Task B

### 1. Task B1 (Table B)

Through Task B1, the user can request and retrieve a data table Table B, which shows the number of confirmed COVID-19 deaths (Total and Per 1 million), on a chosen date, for selected countries, from the given dataset.

Assumption of Task B1
1. We treat the field under the column "location" in the dataset as countries in this application. Therefore some continent or even weird string pattern can be a possible country due to the content of dataset.
2. Assume all total death/total death per 1M are non-negative, if there is a entry with negative value, the generated table will not contain that country.

#### [Task B1] Basic Flow

The Basic Flow assumes that the user will input and navigate everything in the intended order.

0. [Choosing Dataset](#task-b1-0-choosing-dataset)
1. [Enter Table B Tab](#task-b1-1-enter-table-b-tab)
2. [Select Date of Interest](#task-b1-2-select-date-of-interest)
3. [Select Countries of Interest](#task-b1-3-select-countries-of-interest)
4. [Create Table B](#task-b1-4-create-table-b)

##### [Task B1] 0. Choosing Dataset 

The user input the name of dataset to retrieve data from in the Task Zero tab. The default value is the given dataset `COVID_Dataset_v1.0.csv`, so it is fine if the user does not move anything.
<br><img width="720" alt="task-b1-0-choosing-dataset" src="https://user-images.githubusercontent.com/85265131/143687346-fb901182-0ffc-4873-bc53-3a2af6bb1205.png">


##### [Task B1] 1. Enter Table B Tab 

The user enters the Table B Tab to initiate Task B1. (Red Rectangle)

<br><img width="720" alt="task-b1-1-enter-table-b-tab" src="https://user-images.githubusercontent.com/85265131/143687371-6edacf6f-276b-495e-bd5c-5b40235f842b.png">

##### [Task B1] 2. Select Date of Interest 

The user selects the Date of Interest with the date picker. (Green Rectangle)
<br><img width="720" alt="task-b1-2-select-date-of-interest" src="https://user-images.githubusercontent.com/85265131/143687396-4354f89a-1b41-44c9-b0d3-b6cb51f91806.png">

<br><img width="720" alt="opendatepicker" src="https://user-images.githubusercontent.com/85265131/143687430-6b842953-0a91-4b9c-ad78-2ab06e766af4.png">

##### [Task B1] 3. Select Countries of Interest 

The list of countries with data available on the selected date will become open to selection in the dropdown menu. The user selects the Countries of Interest. At least one country should be chosen. 
Note that this step cannot be reached if no date is selected.
<br><img width="720" alt="task-b1-3-select-countries-of-interest" src="https://user-images.githubusercontent.com/85265131/143687459-ea705fc7-7d6d-4bcf-af0d-4593ad419fee.png">
<br><img width="720" alt="selectcountiresfromlist" src="https://user-images.githubusercontent.com/85265131/143687464-d484cb03-4a8e-4a66-877a-74065bfa5afb.png">

##### [Task B1] 4. Create Table B 

The user clicks on the `Generate Table` button to request the system to create the table. The table is generated, with 

* proper title including the Date of Interest
* proper column headings (`Country`,`Total Deaths`,`Total Deaths (per 1M)`)
* complete and accurate results reported.

<br><img width="720" alt="task-b1-4-create-table-b" src="https://user-images.githubusercontent.com/85265131/143687495-3d1bb9cd-c94a-4b77-9827-397a6b6020d9.png">
<br><img width="720" alt="successGenerateTable" src="https://user-images.githubusercontent.com/85265131/143687508-d4d3d6ef-8a81-4e01-a66a-b2074db09607.png">

If the user would like to check console log, the user can click the button `Switch to Console View`, then the console will appear in the original place. If the user would like to have the table just generated again, click the button `Switch to Table View`.

<br><img width="720" alt="switchbacktoconsoleview" src="https://user-images.githubusercontent.com/85265131/143687544-9355ee00-236e-4d91-926e-e5c644d94869.png">
<br>(An example of Pressing `Switch to Console View`)
The use case ends, and the user can return to any of the above steps to create another table.

#### [Task B1] Alternative Flows

The Alternative Flows deal with other situations that may arise when the user interacts with the interface, e.g. input validation.

1. [No Data for Selected Date](#task-b1-extra-alt-1-no-data-for-selected-date)
2. [No Date Selected](#task-b1-alt-2-no-date-selected)
3. [No Country Selected](#task-b1-alt-3-no-country-selected)
4. [No Data for Selected Country on Selected Date](#task-b1-alt-4-no-data-for-selected-country-on-selected-date)

##### [Task B1 Alt] 1. No Data for Selected Date

This flow may occur after [Select Date of Interest](#task-b1-2-select-date-of-interest) in the Basic Flow. After the user selects a Date of Interest, if there is no any record inside the dataset with that input date, the system then displays a error message `No Record on such date, please pick another date.` in the console telling the user to select another date.
<br><img width="717" alt="task-b1-extra-alt-1-no-data-for-selected-date" src="https://user-images.githubusercontent.com/85265131/143687717-c38c647e-4fd4-4c1a-b5e9-0ef88df200ed.png">

<br>The flow of events is resumed (heading back to [Select Date of Interest](#task-b1-2-select-date-of-interest)).

##### [Task B1 Alt] 2. No Date Selected

This flow may occur at [Create Table B](#task-b1-4-create-table-b) in the Basic Flow. After the user clicks the `Generate Table` button, the system may find that no Date of Interest has been selected by the user.
The system then display in console log with message: `Please Enter Date of Interest. `, and asks them to select a date.
<br><img width="717" alt="task-b1-alt-2-no-date-selected" src="https://user-images.githubusercontent.com/85265131/143687695-8910f69c-39f1-4680-811e-7858a4ed7d4f.png">

<br>The flow of events is resumed (heading back to [Select Date of Interest](#task-b1-2-select-date-of-interest)) when the user closes the dialog box.

##### [Task B1 Alt] 3. No Country Selected

This flow may occur at [Create Table B](#task-b1-4-create-table-b) in the Basic Flow. After the user clicks the `Generate Table` button, the system may find that no Country/Countries of Interest has been selected by the user.
The system then output in console stating that `Please Select Countries of Interest. `.
<br><img width="711" alt="task-b1-alt-3-no-country-selected" src="https://user-images.githubusercontent.com/85265131/143688333-fb6b8bdd-7a19-474f-8f2b-0f15b3e18ba4.png">

<br>The flow of events is resumed (heading back to [Select Countries of Interest](#task-b1-3-select-countries-of-interest)) when the user closes the dialog box.

##### [Task B1 Alt] 4. No Data for Selected Country on Selected Date

This flow may occur at [Create Table B](#task-b1-4-create-table-b) in the Basic Flow. After the user clicks the `Generate Table` button, the system begins to create the table, and may find that no data about total deaths/total deaths per 1M is available on the selected date for one (or more) of the countries that have been selected.

The system will displays in console log to inform the user that no data is available for which country/countries.
<br><img width="711" alt="task-b1-alt-4-no-data-for-selected-country-on-selected-date" src="https://user-images.githubusercontent.com/85265131/143688286-5d372f3c-7fa4-46bc-9fb2-9af0f43b68cc.png">
<br><img width="711" alt="Screenshot 2021-11-27 at 11 58 09 PM" src="https://user-images.githubusercontent.com/85265131/143688298-5b7ab297-681a-4215-a696-5451a5363017.png">
<br>The table is then generated with the countries that has data. The flow of events return to the end of [Create Table B](#task-b1-4-create-table-b), where the use case ends and the user can re-enter the case.

### 1.5 Task B1 (Extra Feature): Top 3 Countries with highest death/death per 1M on a given day.

For the extra feature for Task B1, the user can request and retrieve a Table containing the top 3 Countries with highest death/death per 1M on a given day. The logic is similar to the basic feature, an entry missing any one of the total death/total death per 1M is not considered as valid output. Therefore, there exists some countries being the top 3 but not in the output table, it is because they may miss the other data.

#### [B1 Extra] Basic Flow

The Basic Flow assumes that the user will input and navigate everything in the intended order.

0. Choosing Dataset
1. Enter Table B Tab
2. Select Date of Interest
3. [Select Data](#b1-extra-3-select-data)

##### [B1 Extra] 0. Choosing Dataset 

Please refer to [Choosing Dataset](#task-b1-0-choosing-dataset) in the basic flow.

##### [B1 Extra] 1. Enter Table B Tab

Please refer to [Enter Table B Tab](#task-b1-1-enter-table-b-tab) in the basic flow.

##### [B Extra] 2. Select Date of Interest

Please refer to [Select Date of Interest](#task-b1-2-select-date-of-interest) in the basic flow.

##### [B1 Extra] 3. Select Data

The User can click either `Show Top 3 Entries in Death` or `Show Top 3 Entries in Death per 1M`.
<br> <img width="711" alt="b1-extra-3-select-data" src="https://user-images.githubusercontent.com/85265131/143688931-092e7b8a-b0fd-43a9-b717-c634d38589c2.png">
<br><img width="711" alt="Screenshot 2021-11-28 at 12 21 21 AM" src="https://user-images.githubusercontent.com/85265131/143688988-941bde42-d8fc-4180-bead-f71699c99d17.png">
<br>The above image shown the Top 3 Entries in Death on 2020-11-09 in our default dataset.

<br><img width="711" alt="Screenshot 2021-11-28 at 12 21 50 AM" src="https://user-images.githubusercontent.com/85265131/143688993-929a9292-c5d2-43e8-94ac-34eaee36dccb.png">
<br>The above image shown the Top 3 Entries in Death per 1M on 2020-11-09 in our default dataset.

<br>The use case ends.


### 2. Task B2 (Chart B)

Through Task B2, the user can request and retrieve a line chart Chart B, which shows the cumulative number of confirmed COVID-19 Deaths per 1M, in a chosen time period, for selected countries, from the given dataset.

Assumption of Task B2
1. We understand that there may be some statistical errors making some entries having negative Deaths per 1M, therefore although it is a cumulative graph, it may not be strictly increasing due to negative entries.
2. If there is a country missing some data on a particular entry, assume that data to be 0 to prevent the case that the user cannot generate the chart with that country due to some missing data.

#### [Task B2] Basic Flow

The Basic Flow assumes that the user will input and navigate everything in the intended order.

0. [Choosing Dataset](#task-b2-0-choosing-dataset)
1. [Enter Chart B Tab](#task-b2-1-enter-chart-b-tab)
2. [Select Period of Interest](#task-b2-2-select-period-of-interest)
3. [Select Countries of Interest](#task-b2-3-select-countries-of-interest)
4. [Create Chart B](#task-b2-4-create-chart-b)

##### [Task B2] 0. Choosing Dataset

The user chooses the dataset to retrieve data from in the Task Zero tab. The default value is the given dataset `COVID_Dataset_v1.0.csv`, so it is fine if the user does not move anything.
<br><img width="720" alt="task-b2-0-choosing-dataset" src="https://user-images.githubusercontent.com/85265131/143689234-60788462-6c8f-44ee-a976-615513a90cd0.png">


##### [Task B2] 1. Enter Chart B Tab

The user enters the Chart B Tab to initiate Task B2.
<br><img width="711" alt="task-b2-1-enter-chart-b-tab" src="https://user-images.githubusercontent.com/85265131/143689257-c84e306f-a336-44c4-87d4-8a41f82b7509.png">

##### [Task B2] 2. Select Period of Interest

The user selects the Start Date and End Date of Interest with the date pickers.
<br><img width="711" alt="task-b2-2-select-period-of-interest" src="https://user-images.githubusercontent.com/85265131/143689388-4e831c28-8b00-4d80-8481-af2e748efe15.png">
<br><img width="711" alt="Screenshot 2021-11-28 at 12 33 19 AM" src="https://user-images.githubusercontent.com/85265131/143689395-ea575f33-d75b-4829-b82e-fa49eef2f7f6.png">

<br>The Alternative Flow [Invalid Period of Interest](#task-b2-alt-1-invalid-period-of-interest) may arise here.

##### [Task B2] 3. Select Countries of Interest

The list of countries will become open to selection in the dropdown menu. The user selects the Countries of Interest. At least one country should be chosen. 
Note that this step cannot be reached if no valid start date and end date is selected.
<br><img width="711" alt="task-b2-3-select-countries-of-interest" src="https://user-images.githubusercontent.com/85265131/143689462-e2b09f1a-b634-4f76-b090-fd8ad127ccb3.png">

##### [Task B2] 4. Create Chart B

The user clicks on the `Generate Chart` button to request the system to create the line chart. The chart is generated, with 

* proper title including the Period of Interest
* proper x-axis and y-axis
* complete and accurate results reported.
  <br><img width="711" alt="task-b2-4-create-chart-b" src="https://user-images.githubusercontent.com/85265131/143689528-e806d14a-eebe-4744-ac15-05edec95ee4c.png">
  <br>The use case ends, and the user can return to any of the above steps to create another chart.

#### [Task B2] Alternative Flows

The Alternative Flows deal with other situations that may arise when the user interacts with the interface, e.g. input validation.

1. [Invalid Period of Interest](#task-b2-alt-1-invalid-period-of-interest)
2. [No Start Date Selected](#task-b2-alt-2-no-start-date-selected)
3. [No End Date Selected](#task-b2-alt-3-no-end-date-selected)
4. [No Countries Selected](#task-b2-alt-4-no-countries-selected)
5. [No Data for Selected Country in Selected Period](#task-b2-alt-5-no-data-for-selected-country-in-selected-period)

##### [Task B2 Alt] 1. Invalid Period of Interest

This flow may occur after [Select Period of Interest](#task-b2-2-select-period-of-interest) in the Basic Flow. After the user selects a Start Date and End Date of Interest to form the Period of Interest, the period is invalid if the start date is before the end date/the end date is before the start date, or if the start date is the same as the end date.
The system then displays output in the console log to ask for the user to select a proper input.
<br><img width="711" alt="task-b2-alt-1-invalid-period-of-interest" src="https://user-images.githubusercontent.com/85265131/143689678-1a90f4a8-b98c-464a-a49a-9a8f028f673e.png">
<br> The above image shows the output for end date earlier than start date.
<br><img width="711" alt="Screenshot 2021-11-28 at 12 42 27 AM" src="https://user-images.githubusercontent.com/85265131/143689710-e278e02c-6f7e-4e47-85cc-c35f2f6c785f.png">
<br> The above image shows the output for start date earlier than end date.
<br>The flow of events is resumed (heading back to [Select Period of Interest](#task-b2-2-select-period-of-interest)).

##### [Task B2 Alt] 2. No Start Date Selected

This flow may occur at [Create Chart B](#task-b2-4-create-chart-b) in the Basic Flow. After the user clicks the `Generate Chart` button, the system may find that no Start Date of Interest has been selected by the user.
The system then displays in the console log with message: `Please Enter The START Date of Interest. `.
<br><img width="711" alt="task-b2-alt-2-no-start-date-selected" src="https://user-images.githubusercontent.com/85265131/143689783-a1bc0581-1ff1-4bd2-9cbe-f4158718dba5.png">
<br>The flow of events is resumed (heading back to [Select Period of Interest](#task-b2-2-select-period-of-interest)).

##### [Task B2 Alt] 3. No End Date Selected

This flow may occur at [Create Chart B](#task-b2-4-create-chart-b) in the Basic Flow. After the user clicks the `Generate Chart` button, the system may find that no End Date of Interest has been selected by the user.
The system then displays in the console log with message: `Please Enter The END Date of Interest. `.
<br><img width="711" alt="task-b2-alt-3-no-end-date-selected" src="https://user-images.githubusercontent.com/85265131/143689830-23a663f1-00d2-4cf9-99c0-d5a889bb1949.png">
<br>The flow of events is resumed (heading back to [Select Period of Interest](#task-b2-2-select-period-of-interest)).

##### [Task B2 Alt] 4. No Countries Selected

This flow may occur at [Create Chart B](#task-b2-4-create-chart-b) in the Basic Flow. After the user clicks the `Generate Chart` button, the system may find that no country has been selected by the user.
The system then displays in the console log with message: `Please Select Countries of Interest. `.
<br><img width="711" alt="task-b2-alt-4-no-countries-selected" src="https://user-images.githubusercontent.com/85265131/143689865-44dcc232-476b-4a81-a609-6bc92bfaa4f5.png">
<br>The flow of events is resumed (heading back to [Select Countries of Interest](#task-b2-3-select-countries-of-interest)).

##### [Task B2 Alt] 5. No Data for Selected Country within the Selected Period

This flow may occur at [Create Chart B](#task-b2-4-create-chart-b) in the Basic Flow. After the user clicks the `Generate Chart` button, the system begins to create the chart, and may find that there is no data about new deaths per 1M for some dates within Period of Interest for one (or more) of the countries that have been selected.
The system then output in the console log stating which data in which country on which date is missing.
<br><img width="711" alt="task-b2-alt-5-no-data-for-selected-country-in-selected-period" src="https://user-images.githubusercontent.com/85265131/143690001-c095f37f-1f0e-4d25-83da-3c4e15b9142c.png">

We will treat the countries with no data on that particular date having a new death per 1 million being 0, meaning that the country will still on the graph.
<br><img width="711" alt="Screenshot 2021-11-28 at 12 52 45 AM" src="https://user-images.githubusercontent.com/85265131/143690055-39a24c62-df2b-461d-8087-018b40c98809.png">


### 2.5 Task B2 (Extra Feature): Stash

For the extra feature for Task B2, the user can stash the current graph generated (storage size is 1 graph only), and retrieve it at any time the user want.

#### [B2 Extra] Basic Flow

Pre-condition: the user has generated a line chart.
The Basic Flow assumes that the user will input and navigate everything in the intended order.

1. [Stash the current line chart](#b2-extra-1-stash-the-current-line-chart)
2. Some other operation
3. [Retrieve stashed line chart](#b2-extra-3-retrieve-stashed-line-chart)

##### [B2 Extra] 1. Stash the current line chart

The user stash the current line chart by clicking the button `Stash Current Chart Result`. Then the current line chart in the Chart View mode disappeared, and the label on the top right corner changes to `Stashed: True`.
<br><img width="718" alt="Screenshot 2021-11-28 at 2 01 08 PM" src="https://user-images.githubusercontent.com/85265131/143731529-8e2cfa42-5cff-432a-8319-1c26518f8f5a.png">

The stashed line chart can be overwritten, therefore the user can stash the current line chart even if there is a stashed line chart.

##### [B2 Extra] 2. Some other operation

The user may perform any other operation.

##### [B2 Extra] 3. Retrieve stashed line chart

The user retrieve the stashed line chart by clicking the button `Retrieve Stashed Chart Result`. Then the current line chart will be replaced by the stashed line chart. The label on the top right corner changes to `Stashed: False`.

<br><img width="711" alt="b2-extra-3-retrieve-stashed-line-chart" src="https://user-images.githubusercontent.com/85265131/143690515-dbef6b5e-a179-45a4-b7fb-778acff437d4.png">

