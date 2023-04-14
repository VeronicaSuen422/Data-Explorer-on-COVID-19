## Use Case Flow for Task A
This section will demonstrate different sample inputs and the corresponding outputs for different use cases for
* Task A1: Generate data tables showing the number of confirmed COVID-19 cases by country [[Task A1](#1-task-a1-table-a)]
* Commendable features beyond basic requirements for Task A1 [[A1 Extra](#15-task-a1-extra-feature-bar-chart)]
* Task A2: Generate data charts showing the number of confirmed COVID-19 cases by country [[Task A2](#2-task-a2-chart-a)]
* Commendable features beyond basic requirements for Task A2 [[A2 Extra](#25-task-a2-extra-feature-end-date-calculator)]

### 1. Task A1 (Table A)
Through Task A1, the user can request and retrieve a data table Table A, which shows the number of confirmed COVID-19 cases, on a chosen date, for selected countries, from the given dataset.

#### [Task A1] Basic Flow
The Basic Flow assumes that the user will input and navigate everything in the intended order.

0. [Choosing Dataset](#task-a1-0-choosing-dataset)
1. [Enter Table A Tab](#task-a1-1-enter-table-a-tab) 
2. [Select Date of Interest](#task-a1-2-select-date-of-interest)
3. [Select Countries of Interest](#task-a1-3-select-countries-of-interest)
4. [Create Table A](#task-a1-4-create-table-a)

##### [Task A1] 0. Choosing Dataset 
The user chooses the dataset to retrieve data from in the Task Zero tab. The default value is the given dataset `COVID_Dataset_v1.0.csv`, so it is fine if the user does not move anything.
<br><img width="720" alt="task-a1-0-choosing-dataset-new" src="https://user-images.githubusercontent.com/90368282/143718897-fd25a602-4564-42b2-ae01-24aca06a20af.png">

##### [Task A1] 1. Enter Table A Tab
The user enters the Table A Tab to initiate Task A1.
<br><img width="715" alt="task-a1-1-enter-table-a-tab" src="https://user-images.githubusercontent.com/90368282/143087314-85168ed3-bcf2-4e8f-a0b4-34ae1d2094de.png">

##### [Task A1] 2. Select Date of Interest
The user selects the Date of Interest with the date picker.
<br><img width="715" alt="task-a1-2-select-date-of-interest" src="https://user-images.githubusercontent.com/90368282/143087332-4339da8e-e449-428f-977f-820a9374c2e1.png">
<br>See [No Data for Selected Date](#a1-extra-alt-1-no-data-for-selected-date) for the Alternative Flow that may arise after this step.

##### [Task A1] 3. Select Countries of Interest
The list of countries with data available on the selected date will become open to selection in the dropdown menu. The user selects the Countries of Interest. At least one country should be chosen. 
Note that this step cannot be reached if no date is selected.
<br><img width="718" alt="task-a1-3-select-countries-of-interest" src="https://user-images.githubusercontent.com/90368282/143087346-fcf1e382-114e-4990-984c-fa22b80952d2.png">

##### [Task A1] 4. Create Table A
The user clicks on the `Create Table` button to request the system to create the table. Alternative Flows ([No Date Selected](#task-a1-alt-2-no-date-selected), [No Country Selected](#task-a1-alt-3-no-country-selected), [No Data for Selected Country on Selected Date](#task-a1-alt-4-no-data-for-selected-country-on-selected-date)) may occur at this stage. The table is generated, with 
* proper title including the Date of Interest
* proper column headings (`Country`,`Total Cases`,`Total Cases (per 1M)`)
* complete and accurate results reported.

<br><img width="716" alt="task-a1-4-create-table-a" src="https://user-images.githubusercontent.com/90368282/143087367-ca8bed40-820c-40cd-976e-4c5f7f9bc3a5.png">

The use case ends, and the user can return to any of the above steps to create another table.

#### [Task A1] Alternative Flows
The Alternative Flows deal with other situations that may arise when the user interacts with the interface, e.g. input validation.

1. [No Data for Selected Date](#a1-extra-alt-1-no-data-for-selected-date)
2. [No Date Selected](#task-a1-alt-2-no-date-selected)
3. [No Country Selected](#task-a1-alt-3-no-country-selected)
4. [No Data for Selected Country on Selected Date](#task-a1-alt-4-no-data-for-selected-country-on-selected-date)
5. [No Data for All Selected Countries on Selected Date](#task-a1-alt-5-no-data-for-all-selected-countries-on-selected-date)

##### [Task A1 Alt] 1. No Data for Selected Date
This flow may occur after [Select Date of Interest](#task-a1-2-select-date-of-interest) in the Basic Flow. After the user selects a Date of Interest, the system may find that no data is available for all countries on the selected date.
The system then displays a dialog box informing the user, and asks them to select another date.
<br><img width="718" alt="task-a1-alt-1-no-data-for-selected-date" src="https://user-images.githubusercontent.com/90368282/143087391-e530dddb-8e59-4633-9865-78e0136829cb.png">
<br>The flow of events is resumed (heading back to [Select Date of Interest](#task-a1-2-select-date-of-interest)) when the user closes the dialog box.

##### [Task A1 Alt] 2. No Date Selected
This flow may occur at [Create Table A](#task-a1-4-create-table-a) in the Basic Flow. After the user clicks the `Create Table` button, the system may find that no Date of Interest has been selected by the user.
The system then displays a dialog box informing the user, and asks them to select a date.
<br><img width="719" alt="task-a1-alt-2-no-date-selected" src="https://user-images.githubusercontent.com/90368282/143087407-42ec97ea-4f81-47d9-8e40-49936a30ed75.png">
<br>The flow of events is resumed (heading back to [Select Date of Interest](#task-a1-2-select-date-of-interest)) when the user closes the dialog box.

##### [Task A1 Alt] 3. No Country Selected
This flow may occur at [Create Table A](#task-a1-4-create-table-a) in the Basic Flow. After the user clicks the `Create Table` button, the system may find that no Country/Countries of Interest has been selected by the user.
The system then displays a dialog box informing the user, and asks them to select the country/countries.
<br><img width="714" alt="task-a1-alt-3-no-country-selected-1" src="https://user-images.githubusercontent.com/90368282/143087465-18e53f27-07ce-4abd-925e-1432003c0941.png">
<br><img width="715" alt="task-a1-alt-3-no-country-selected-2" src="https://user-images.githubusercontent.com/90368282/143087471-77fdba03-d1d1-4d81-a9ba-424b8d2b04e3.png">
<br>The flow of events is resumed (heading back to [Select Countries of Interest](#task-a1-3-select-countries-of-interest)) when the user closes the dialog box.

##### [Task A1 Alt] 4. No Data for Selected Country on Selected Date
This flow may occur at [Create Table A](#task-a1-4-create-table-a) in the Basic Flow. After the user clicks the `Create Table` button, the system begins to create the table, and may find that no data about total cases is available  on the selected datefor one (or more) of the countries that have been selected.
The system then displays a dialog box informing the user that no data is available for that country.
<br><img width="720" alt="task-a1-alt-4-no-data-for-selected-country-on-selected-date-1" src="https://user-images.githubusercontent.com/90368282/143087524-cac375da-140e-4801-a5ae-7c5c36c75767.png">
<br><img width="723" alt="task-a1-alt-4-no-data-for-selected-country-on-selected-date-2" src="https://user-images.githubusercontent.com/90368282/143087529-1ebbdf46-902f-44c7-b23a-fa8e34f87e5a.png">
<br><img width="720" alt="task-a1-alt-4-no-data-for-selected-country-on-selected-date-3" src="https://user-images.githubusercontent.com/90368282/143087535-3c1819d7-7ac7-443b-b5a6-b3e1962040cd.png">
<br>If there is data available for other selected countries, the table is then generated with the warned countries excluded. The flow of events return to the end of [Create Table A](#task-a1-4-create-table-a), where the use case ends and the user can re-enter the case.
Otherwise, we head to [No Data for All Selected Countries on Selected Date](#task-a1-alt-5-no-data-for-all-selected-countries-on-selected-date)].

##### [Task A1 Alt] 5. No Data for All Selected Countries on Selected Date
This flow may occur after the above, if no data about total cases is available  on the selected datefor all the countries that have been selected.
The system then displays a dialog box informing the user that no data is available for all the selected countries, and asks them to select again. 
<br><img width="715" alt="task-a1-alt-5-no-data-for-all-selected-countries-on-selected-date-1" src="https://user-images.githubusercontent.com/90368282/143087643-3379d063-5364-4ecb-817b-ec81a851c643.png">
<br><img width="715" alt="task-a1-alt-5-no-data-for-all-selected-countries-on-selected-date-2" src="https://user-images.githubusercontent.com/90368282/143087649-bfa4530f-2407-4972-933d-27837403f4db.png">
<br><img width="715" alt="task-a1-alt-5-no-data-for-all-selected-countries-on-selected-date-3" src="https://user-images.githubusercontent.com/90368282/143087651-4a3d379c-c2c4-4069-a3f1-230be592cb40.png">
<br><img width="718" alt="task-a1-alt-5-no-data-for-all-selected-countries-on-selected-date-4" src="https://user-images.githubusercontent.com/90368282/143087654-a5f3b316-3d18-426b-ad85-3d8d36cd0f43.png">
<br>The flow of events return to [Select Countries of Interest](#task-a1-3-select-countries-of-interest).

### 1.5 Task A1 (Extra Feature): Bar Chart
For the extra feature for Task A1, the user can request and retrieve a Bar Chart, which shows the number of confirmed COVID-19 cases, on a chosen date, for selected countries, from the given dataset.

#### [A1 Extra] Basic Flow
The Basic Flow assumes that the user will input and navigate everything in the intended order.

0. [Choosing Dataset](#a1-extra-0-choosing-dataset)
1. [Enter Table A Tab](#a1-extra-1-enter-table-a-tab) 
2. [Select Date of Interest](#a1-extra-2-select-date-of-interest)
3. [Select Countries of Interest](#a1-extra-3-select-countries-of-interest)
4. [Create Bar Chart](#a1-extra-4-create-bar-chart)

##### [A1 Extra] 0. Choosing Dataset 
The user chooses the dataset to retrieve data from in the Task Zero tab. The default value is the given dataset `COVID_Dataset_v1.0.csv`, so it is fine if the user does not move anything.
<br><img width="720" alt="a1-extra-0-choosing-dataset-new" src="https://user-images.githubusercontent.com/90368282/143718883-d431cd0b-4882-4b85-8bb6-5cf40a14aa4e.png">

##### [A1 Extra] 1. Enter Table A Tab
The user enters the Table A Tab to initiate Task A1.
<br><img width="718" alt="a1-extra-1-enter-table-a-tab" src="https://user-images.githubusercontent.com/90368282/143183188-dcff88c1-7a1e-414e-ba14-222f07d01971.png">

##### [A1 Extra] 2. Select Date of Interest
The user selects the Date of Interest with the date picker.
<br><img width="715" alt="a1-extra-2-select-date-of-interest" src="https://user-images.githubusercontent.com/90368282/143183198-bb22abe9-3ae9-4146-95ef-0fc0c3787339.png">
<br>See [No Data for Selected Date](#a1-extra-alt-1-no-data-for-selected-date) for the Alternative Flow that may arise after this step.

##### [A1 Extra] 3. Select Countries of Interest
The list of countries with data available on the selected date will become open to selection in the dropdown menu. The user selects the Countries of Interest. At least one country should be chosen. 
Note that this step cannot be reached if no date is selected.
<br><img width="718" alt="a1-extra-3-select-countries-of-interest" src="https://user-images.githubusercontent.com/90368282/143183280-bddad37e-e4a5-40a7-a65c-f3746ca51fb0.png">


##### [A1 Extra] 4. Create Bar Chart
The user clicks on the `Create Bar Chart` button to request the system to create the table. Alternative Flows ([No Date Selected](#a1-extra-alt-2-no-date-selected), [No Country Selected](#a1-extra-alt-3-no-country-selected), [No Data for Selected Country on Selected Date](#a1-extra-alt-4-no-data-for-selected-country-on-selected-date)) may occur at this stage. The chart is generated, with 
* proper title including the Date of Interest
* proper x-axis and y-axis
* complete and accurate results reported.

<br><img width="716" alt="a1-extra-4-create-bar-chart" src="https://user-images.githubusercontent.com/90368282/143183297-bdc4636d-40da-460d-b6cd-0b9771601ff4.png">
<br>The use case ends, and the user can return to any of the above steps to create another table.

#### [A1 Extra] Alternative Flows
The Alternative Flows deal with other situations that may arise when the user interacts with the interface, e.g. input validation.

1. [No Data for Selected Date](#a1-extra-alt-1-no-data-for-selected-date)
2. [No Date Selected](#a1-extra-alt-2-no-date-selected)
3. [No Country Selected](#a1-extra-alt-3-no-country-selected)
4. [No Data for Selected Country on Selected Date](#a1-extra-alt-4-no-data-for-selected-country-on-selected-date)
5. [No Data for All Selected Countries on Selected Date](#a1-extra-alt-5-no-data-for-all-selected-countries-on-selected-date)

##### [A1 Extra Alt] 1. No Data for Selected Date
This flow may occur after [Select Date of Interest](#a1-extra-2-select-date-of-interest) in the Basic Flow. After the user selects a Date of Interest, the system may find that no data is available for all countries on the selected date.
The system then displays a dialog box informing the user, and asks them to select another date.
<br><img width="718" alt="a1-extra-alt-1-no-data-for-selected-date" src="https://user-images.githubusercontent.com/90368282/143183327-fd4b93be-ce63-41d1-b77b-045a9cdd35ef.png">
<br>The flow of events is resumed (heading back to [Select Date of Interest](#a1-extra-2-select-date-of-interest)) when the user closes the dialog box.

##### [A1 Extra Alt] 2. No Date Selected
This flow may occur at [Create Bar Chart](#a1-extra-4-create-bar-chart) in the Basic Flow. After the user clicks the `Create Bar Chart` button, the system may find that no Date of Interest has been selected by the user.
The system then displays a dialog box informing the user, and asks them to select a date.
<br><img width="719" alt="a1-extra-alt-2-no-date-selected" src="https://user-images.githubusercontent.com/90368282/143183345-ef0be496-c8d3-44bf-b8a0-1074849a1a76.png">
<br>The flow of events is resumed (heading back to [Select Date of Interest](#a1-extra-2-select-date-of-interest)) when the user closes the dialog box.

##### [A1 Extra Alt] 3. No Country Selected
This flow may occur at [Create Bar Chart](#a1-extra-4-create-bar-chart) in the Basic Flow. After the user clicks the `Create Bar Chart` button, the system may find that no Country/Countries of Interest has been selected by the user.
The system then displays a dialog box informing the user, and asks them to select the country/countries.
<br><img width="714" alt="a1-extra-alt-3-no-country-selected-1" src="https://user-images.githubusercontent.com/90368282/143183373-b47301ef-f989-4b30-95d4-7318f070f738.png">
<br><img width="715" alt="a1-extra-alt-3-no-country-selected-2" src="https://user-images.githubusercontent.com/90368282/143183375-3c987c52-5d0f-49c0-ad0f-0f8dded207a4.png">
<br>The flow of events is resumed (heading back to [Select Countries of Interest](#task-a1-3-select-countries-of-interest)) when the user closes the dialog box.

##### [A1 Extra Alt] 4. No Data for Selected Country on Selected Date
This flow may occur at [Create Bar Chart](#a1-extra-4-create-bar-chart) in the Basic Flow. After the user clicks the `Create Bar Chart` button, the system begins to create the chart, and may find that no data about total cases is available on the selected date for one (or more) of the countries that have been selected.
The system then displays a dialog box informing the user that no data is available for that country.
<br><img width="720" alt="a1-extra-alt-4-no-data-for-selected-country-on-selected-date-1" src="https://user-images.githubusercontent.com/90368282/143183451-8c9a585b-0c12-4565-be9e-e636c7908e72.png">
<br><img width="713" alt="a1-extra-alt-4-no-data-for-selected-country-on-selected-date-2" src="https://user-images.githubusercontent.com/90368282/143185854-f9c5f49a-afe3-4e3e-a752-290925d15857.png">
<br><img width="717" alt="a1-extra-alt-4-no-data-for-selected-country-on-selected-date-3" src="https://user-images.githubusercontent.com/90368282/143183460-c0eb0902-7d83-4820-87c4-f4b613ef0d06.png">
<br>If there is data available for other selected countries, the chart is then generated with the warned countries excluded. The flow of events return to the end of [Create Bar Chart](#a1-extra-4-create-bar-chart), where the use case ends and the user can re-enter the case.
Otherwise, we head to [No Data for All Selected Countries on Selected Date](#a1-extra-alt-5-no-data-for-all-selected-countries-on-selected-date)].

##### [A1 Extra Alt] 5. No Data for All Selected Countries on Selected Date
This flow may occur after the above, if no data about total cases is available on the selected date for all the countries that have been selected.
The system then displays a dialog box informing the user that no data is available for all the selected countries, and asks them to select again. 
<br><img width="715" alt="a1-extra-alt-5-no-data-for-all-selected-countries-on-selected-date-1" src="https://user-images.githubusercontent.com/90368282/143183510-d4f304e0-71d6-4160-9481-519d95fe7d4a.png">
<br><img width="718" alt="a1-extra-alt-5-no-data-for-all-selected-countries-on-selected-date-2" src="https://user-images.githubusercontent.com/90368282/143185897-d06f0b69-0546-4b9e-9eba-7ddcdbb610c1.png">
<br><img width="713" alt="a1-extra-alt-5-no-data-for-all-selected-countries-on-selected-date-3" src="https://user-images.githubusercontent.com/90368282/143185905-0df45ce4-1cb8-450a-a68c-c0d2ab593fc4.png">
<br><img width="718" alt="a1-extra-alt-5-no-data-for-all-selected-countries-on-selected-date-4" src="https://user-images.githubusercontent.com/90368282/143183522-1be8ce89-b0a5-40d8-964a-8cffaa4ea00f.png">
<br>The flow of events return to [Select Countries of Interest](#task-a1-3-select-countries-of-interest).

### 2. Task A2 (Chart A)
Through Task A2, the user can request and retrieve a line chart Chart A, which shows the cumulative number of confirmed COVID-19 cases, in a chosen time period, for selected countries, from the given dataset.

#### [Task A2] Basic Flow
The Basic Flow assumes that the user will input and navigate everything in the intended order.

0. [Choosing Dataset](#task-a2-0-choosing-dataset)
1. [Enter Chart A Tab](#task-a2-1-enter-chart-a-tab)
2. [Select Period of Interest](#task-a2-2-select-period-of-interest)
3. [Select Countries of Interest](#task-a2-3-select-countries-of-interest)
4. [Create Chart A](#task-a2-4-create-chart-a)

##### [Task A2] 0. Choosing Dataset
The user chooses the dataset to retrieve data from in the Task Zero tab. The default value is the given dataset `COVID_Dataset_v1.0.csv`, so it is fine if the user does not move anything.
<br><img width="720" alt="task-a2-0-choosing-dataset-new" src="https://user-images.githubusercontent.com/90368282/143718879-3b827f6d-3ebe-4c14-b3af-32b557e240aa.png">

##### [Task A2] 1. Enter Chart A Tab
The user enters the Chart A Tab to initiate Task A2.
<br><img width="717" alt="task-a2-1-enter-chart-a-tab" src="https://user-images.githubusercontent.com/90368282/143187717-5edf7c5a-19f8-4b16-80e9-727441306147.png">

##### [Task A2] 2. Select Period of Interest
The user selects the Start Date and End Date of Interest with the date pickers.
<br><img width="716" alt="task-a2-2-select-period-of-interest-1" src="https://user-images.githubusercontent.com/90368282/143187740-3ce03329-96fb-4e9a-a43e-97199a957500.png">
<br><img width="716" alt="task-a2-2-select-period-of-interest-2" src="https://user-images.githubusercontent.com/90368282/143187746-8a1a9f5a-d6ef-4141-bea4-badf4b04d30d.png">
<br>The Alternative Flow [Invalid Period of Interest](#task-a2-alt-1-invalid-period-of-interest) may arise here.

##### [Task A2] 3. Select Countries of Interest
The list of countries with data available on the selected date will become open to selection in the dropdown menu. The user selects the Countries of Interest. At least one country should be chosen. 
Note that this step cannot be reached if no start date is selected.
<br><img width="717" alt="task-a2-3-select-countries-of-interest" src="https://user-images.githubusercontent.com/90368282/143187791-06e7f747-7144-4639-95de-54dd6ae3ad69.png">

##### [Task A2] 4. Create Chart A
The user clicks on the `Create Chart` button to request the system to create the line chart. Alternative Flows ([No Start Date Selected](#task-a2-alt-2-no-start-date-selected), [No End Date Selected](#task-a2-alt-3-no-end-date-selected), [No Countries Selected](#task-a2-alt-4-no-countries-selected), [No Data for Selected Country in Selected Period](#task-a2-alt-5-no-data-for-selected-country-in-selected-period)) may occur at this stage. The chart is generated, with 
* proper title including the Period of Interest
* proper x-axis and y-axis
* complete and accurate results reported.
<br><img width="717" alt="task-a2-4-create-chart-a" src="https://user-images.githubusercontent.com/90368282/143187822-18729aab-2400-4539-82b7-58389ed01d15.png">
<br>The use case ends, and the user can return to any of the above steps to create another chart.

#### [Task A2] Alternative Flows
The Alternative Flows deal with other situations that may arise when the user interacts with the interface, e.g. input validation.

1. [Invalid Period of Interest](#task-a2-alt-1-invalid-period-of-interest)
2. [No Start Date Selected](#task-a2-alt-2-no-start-date-selected)
3. [No End Date Selected](#task-a2-alt-3-no-end-date-selected)
4. [No Countries Selected](#task-a2-alt-4-no-countries-selected)
5. [No Data for Selected Country in Selected Period](#task-a2-alt-5-no-data-for-selected-country-in-selected-period)
6. [No Data for All Selected Countries in Selected Period](#task-a2-alt-6-no-data-for-all-selected-countries-in-selected-period)

##### [Task A2 Alt] 1. Invalid Period of Interest
This flow may occur after [Select Period of Interest](#task-a2-2-select-period-of-interest) in the Basic Flow. After the user selects a Start Date and End Date of Interest to form the Period of Interest, the period is invalid if the start date is before the end date/the end date is before the start date, or if the start date is the same as the end date.
The system then displays a dialog box informing the user, and asks them to select an earlier start date and/or a later end date.
<br><img width="719" alt="task-a2-alt-1-invalid-period-of-interest-1" src="https://user-images.githubusercontent.com/90368282/143187845-0b10102f-475a-47eb-8b6c-36773e2b0b03.png">
<br><img width="717" alt="task-a2-alt-1-invalid-period-of-interest-2" src="https://user-images.githubusercontent.com/90368282/143187850-d089137d-ebaa-45d2-ac08-a8a83ea4a745.png">
<br>The flow of events is resumed (heading back to [Select Period of Interest](#task-a2-2-select-period-of-interest)) when the user closes the dialog box.

##### [Task A2 Alt] 2. No Start Date Selected
This flow may occur at [Create Chart A](#task-a2-4-create-chart-a) in the Basic Flow. After the user clicks the `Create Chart` button, the system may find that no Start Date of Interest has been selected by the user.
The system then displays a dialog box informing the user, and asks them to select a start date.
<br><img width="717" alt="task-a2-alt-2-no-start-date-selected" src="https://user-images.githubusercontent.com/90368282/143187872-ee60134b-7564-46af-a142-2760c03a3618.png">
<br>The flow of events is resumed (heading back to [Select Period of Interest](#task-a2-2-select-period-of-interest)) when the user closes the dialog box.

##### [Task A2 Alt] 3. No End Date Selected
This flow may occur at [Create Chart A](#task-a2-4-create-chart-a) in the Basic Flow. After the user clicks the `Create Chart` button, the system may find that no End Date of Interest has been selected by the user.
The system then displays a dialog box informing the user, and asks them to select an end date.
<br><img width="718" alt="task-a2-alt-3-no-end-date-selected" src="https://user-images.githubusercontent.com/90368282/143187896-1946e08f-890c-4f96-a698-ea0115a8f4fc.png">
<br>The flow of events is resumed (heading back to [Select Period of Interest](#task-a2-2-select-period-of-interest)) when the user closes the dialog box.

##### [Task A2 Alt] 4. No Countries Selected
This flow may occur at [Create Chart A](#task-a2-4-create-chart-a) in the Basic Flow. After the user clicks the `Create Chart` button, the system may find that no country has been selected by the user.
The system then displays a dialog box informing the user, and asks them to select a country/some countries.
<br><img width="717" alt="task-a2-alt-4-no-countries-selected-1" src="https://user-images.githubusercontent.com/90368282/143187928-e916aa1f-3d72-4a91-b087-4b9dc4e1f02e.png">
<br><img width="719" alt="task-a2-alt-4-no-countries-selected-2" src="https://user-images.githubusercontent.com/90368282/143187936-59d4d474-05a3-4c5c-a9be-2bb33b85f1b6.png">
<br>The flow of events is resumed (heading back to [Select Countries of Interest](#task-a2-3-select-countries-of-interest)) when the user closes the dialog box.

##### [Task A2 Alt] 5. No Data for Selected Country in Selected Period
This flow may occur at [Create Chart A](#task-a2-4-create-chart-a) in the Basic Flow. After the user clicks the `Create Chart` button, the system begins to create the chart, and may find that no data about total cases during the whole Period of Interest is available for one (or more) of the countries that have been selected.
The system then displays a dialog box informing the user that no data is available for that country.
<br><img width="719" alt="task-a2-alt-5-no-data-for-selected-country-in-selected-period-1" src="https://user-images.githubusercontent.com/90368282/143187972-a1c0ef6a-ae84-4d56-84ff-86b4d1be3e3f.png">
<br><img width="717" alt="task-a2-alt-5-no-data-for-selected-country-in-selected-period-2" src="https://user-images.githubusercontent.com/90368282/143187976-084cfd37-6a77-479d-9dee-2d9209092b79.png">
<br><img width="715" alt="task-a2-alt-5-no-data-for-selected-country-in-selected-period-3" src="https://user-images.githubusercontent.com/90368282/143187977-df062f2f-4984-4e1a-b7fe-7d3a9cb1d4ca.png">
<br>If there is data available for other selected countries, the chart is then generated with the warned countries excluded. The flow of events return to the end of [Create Chart A](#task-a2-4-create-chart-a), where the use case ends and the user can re-enter the case.
Otherwise, we head to [No Data for All Selected Countries in Selected Period](#task-a2-alt-6-no-data-for-all-selected-countries-in-selected-period))].

##### [Task A2 Alt] 6. No Data for All Selected Countries in Selected Period
This flow may occur after the above, if no data about total cases is available during the whole Period of Interest for all the countries that have been selected.
The system then displays a dialog box informing the user that no data is available for all the selected countries, and asks them to select again. 
<br><img width="717" alt="task-a2-alt-6-no-data-for-all-selected-countries-in-selected-period-1" src="https://user-images.githubusercontent.com/90368282/143188023-d8ad5956-11eb-44cf-9614-c4c65129b836.png">
<br><img width="716" alt="task-a2-alt-6-no-data-for-all-selected-countries-in-selected-period-2" src="https://user-images.githubusercontent.com/90368282/143188029-5131fb0e-c7f7-475b-84b7-a33c625b2191.png">
<br><img width="717" alt="task-a2-alt-6-no-data-for-all-selected-countries-in-selected-period-3" src="https://user-images.githubusercontent.com/90368282/143188035-9ab0a0a5-2bdb-431e-b19c-fb76ab8a9dc1.png">
<br><img width="715" alt="task-a2-alt-6-no-data-for-all-selected-countries-in-selected-period-4" src="https://user-images.githubusercontent.com/90368282/143201878-9331cfb1-57a9-4f16-8a36-96571547f8da.png">
<br>The flow of events return to [Select Countries of Interest](#task-a2-3-select-countries-of-interest).

### 2.5 Task A2 (Extra Feature): End Date Calculator
For the extra feature for Task A2, instead of selecting the End Date of Interest with the date picker directly, the user may use the End Date Calculator and select the desired duration of time after the selected start date. The End Date of Interest will then be calculated and applied. 

#### [A2 Extra] Basic Flow
The Basic Flow assumes that the user will input and navigate everything in the intended order.

0. [Choosing Dataset](#a2-extra-0-choosing-dataset)
1. [Enter Chart A Tab](#a2-extra-1-enter-chart-a-tab)
2. [Select Start Date of Interest](#a2-extra-2-select-start-date-of-interest)
3. [Calculate End Date of Interest](#a2-extra-3-calculate-end-date-of-interest)
4. [Select Countries of Interest](#a2-extra-4-select-countries-of-interest)
5. [Create Chart A](#a2-extra-5-create-chart-a)

##### [A2 Extra] 0. Choosing Dataset
The user chooses the dataset to retrieve data from in the Task Zero tab. The default value is the given dataset `COVID_Dataset_v1.0.csv`, so it is fine if the user does not move anything.
<br><img width="720" alt="a2-extra-0-choosing-dataset-new" src="https://user-images.githubusercontent.com/90368282/143718866-f8e74df4-c282-4c71-af2f-f9c1f4704aac.png">

##### [A2 Extra] 1. Enter Chart A Tab
The user enters the Chart A Tab to initiate Task A2.
<br><img width="717" alt="a2-extra-1-enter-chart-a-tab" src="https://user-images.githubusercontent.com/90368282/143202031-79e3692d-a7f7-4ff3-92ac-f9fa7492335e.png">

##### [A2 Extra] 2. Select Start Date of Interest
The user selects the Start Date of Interest with the start date picker.
<br><img width="718" alt="a2-extra-2-select-start-date-of-interest" src="https://user-images.githubusercontent.com/90368282/143202068-868b2c7d-81f2-48fb-aa7a-3ebcf48b852f.png">

##### [A2 Extra] 3. Calculate End Date of Interest
The user then fills in a desired duration in the `Months` and `Days` text fields, and clicks `Calculate`. The fields have default value `0`, so the user may also only choose to change one of the fields. The End Date of Interest is calculated and appears in the end date picker. 
<br><img width="717" alt="a2-extra-3-calculate-end-date-of-interest-1" src="https://user-images.githubusercontent.com/90368282/143202216-72610e69-9c61-432b-91be-d02e93441c61.png">
<br><img width="717" alt="a2-extra-3-calculate-end-date-of-interest-2" src="https://user-images.githubusercontent.com/90368282/143202223-9189f5ea-584f-4b0e-b3c4-c090259b7428.png">
<br>Alternative Flows ([Invalid Period of Interest](#a2-extra-alt-1-invalid-period-of-interest), [No Start Date Selected](#a2-extra-alt-2-no-start-date-selected)) may occur here.
Also, the user may still use the end date picker to select the End Date of Interest manually like in [Select Period of Interest](#task-a2-2-select-period-of-interest) in the Basic Flow of the original task. 

##### [A2 Extra] 4. Select Countries of Interest
The list of countries with data available on the selected date will become open to selection in the dropdown menu. The user selects the Countries of Interest. At least one country should be chosen. 
Note that this step cannot be reached if no start date is selected.
<br><img width="717" alt="a2-extra-4-select-countries-of-interest" src="https://user-images.githubusercontent.com/90368282/143202350-8f5a5513-5000-462f-b84d-8bcb66122a44.png">

##### [A2 Extra] 5. Create Chart A
The user clicks on the `Create Chart` button to request the system to create the line chart. Alternative Flows ([No Start Date Selected](#a2-extra-alt-2-no-start-date-selected), [No End Date Selected](#a2-extra-alt-3-no-end-date-selected), [No Countries Selected](#a2-extra-alt-4-no-countries-selected), [No Data for Selected Country in Selected Period](#a2-extra-alt-5-no-data-for-selected-country-in-selected-period)) may occur at this stage. The chart is generated, with 
* proper title including the Period of Interest
* proper x-axis and y-axis
* complete and accurate results reported.

<br><img width="718" alt="a2-extra-5-create-chart-a" src="https://user-images.githubusercontent.com/90368282/143202391-348109c2-6b39-45ff-8bf1-95d523776a85.png">
<br>The use case ends, and the user can return to any of the above steps to create another chart.

#### [A2 Extra] Alternative Flows
The Alternative Flows deal with other situations that may arise when the user interacts with the interface, e.g. input validation.

1. [Invalid Period of Interest](#a2-extra-alt-1-invalid-period-of-interest)
2. [No Start Date Selected](#a2-extra-alt-2-no-start-date-selected)
3. [No End Date Selected](#a2-extra-alt-3-no-end-date-selected)
4. [No Countries Selected](#a2-extra-alt-4-no-countries-selected)
5. [No Data for Selected Country in Selected Period](#a2-extra-alt-5-no-data-for-selected-country-in-selected-period)
6. [No Data for All Selected Countries in Selected Period](#a2-extra-alt-6-no-data-for-all-selected-countries-in-selected-period)

##### [A2 Extra Alt] 1. Invalid Period of Interest
This flow may occur after [Calculate End Date of Interest](#a2-extra-3-calculate-end-date-of-interest) in the Basic Flow. After the user selects a Start Date of Interest and calculates/selects an End Date of Interest to form the Period of Interest, the period is invalid if the start date is before the end date/the end date is before the start date, or if the start date is the same as the end date.
The system then displays a dialog box informing the user, and asks them to select an earlier start date and/or a later end date.
<br><img width="720" alt="a2-extra-alt-1-invalid-period-of-interest-1" src="https://user-images.githubusercontent.com/90368282/143202465-5a7ed976-664b-43fe-8999-1a939e8bc67f.png">
<br><img width="717" alt="a2-extra-alt-1-invalid-period-of-interest-2" src="https://user-images.githubusercontent.com/90368282/143202478-0c69f9e0-99a6-4a54-adb2-170580e389a8.png">
<br>The flow of events is resumed (heading back to [Select Start Date of Interest](#a2-extra-2-select-start-date-of-interest)) when the user closes the dialog box.

##### [A2 Extra Alt] 2. No Start Date Selected
This flow may occur at [Calculate End Date of Interest](#a2-extra-3-calculate-end-date-of-interest) and [Create Chart A](#a2-extra-5-create-chart-a) in the Basic Flow. After the user clicks the `Calculate` or `Create Chart` button, the system may find that no Start Date of Interest has been selected by the user.
The system then displays a dialog box informing the user, and asks them to select a start date.
<br><img width="720" alt="a2-extra-alt-2-no-start-date-selected" src="https://user-images.githubusercontent.com/90368282/143202580-e8966344-1de4-491e-926f-db58156a5aa8.png">
<br>The flow of events is resumed (heading back to [Select Start Date of Interest](#a2-extra-2-select-start-date-of-interest)) when the user closes the dialog box.

##### [A2 Extra Alt] 3. No End Date Selected
This flow may occur at [Create Chart A](#a2-extra-5-create-chart-a) in the Basic Flow. After the user clicks the `Create Chart` button, the system may find that no End Date of Interest has been selected by the user.
The system then displays a dialog box informing the user, and asks them to select an end date.
<br><img width="718" alt="a2-extra-alt-3-no-end-date-selected" src="https://user-images.githubusercontent.com/90368282/143202636-6a4f79f1-9e17-4494-a9ee-db1c796ee541.png">
<br>The flow of events is resumed (heading back to [Calculate End Date of Interest](#a2-extra-3-calculate-end-date-of-interest)) when the user closes the dialog box.

##### [A2 Extra Alt] 4. No Countries Selected
This flow may occur at [Create Chart A](#a2-extra-5-create-chart-a) in the Basic Flow. After the user clicks the `Create Chart` button, the system may find that no country has been selected by the user.
The system then displays a dialog box informing the user, and asks them to select a country/some countries.
<br><img width="717" alt="a2-extra-alt-4-no-countries-selected-1" src="https://user-images.githubusercontent.com/90368282/143202703-67d351ff-e87e-4836-96bf-8f6bc609eeca.png">
<br><img width="717" alt="a2-extra-alt-4-no-countries-selected-2" src="https://user-images.githubusercontent.com/90368282/143202710-9b5c10a3-9ef0-4693-b961-a14faaa477e7.png">
<br>The flow of events is resumed (heading back to [Select Countries of Interest](#a2-extra-4-select-countries-of-interest)) when the user closes the dialog box.

##### [A2 Extra Alt] 5. No Data for Selected Country in Selected Period
This flow may occur at [Create Chart A](#a2-extra-5-create-chart-a) in the Basic Flow. After the user clicks the `Create Chart` button, the system begins to create the chart, and may find that no data about total cases during the whole Period of Interest is available for one (or more) of the countries that have been selected.
The system then displays a dialog box informing the user that no data is available for that country.
<br><img width="717" alt="a2-extra-alt-5-no-data-for-selected-country-in-selected-period-1" src="https://user-images.githubusercontent.com/90368282/143202779-f5f368a6-ba80-4132-8337-d22b87434c66.png">
<br><img width="719" alt="a2-extra-alt-5-no-data-for-selected-country-in-selected-period-2" src="https://user-images.githubusercontent.com/90368282/143202798-cac65fed-2693-4fe7-b064-f6bd460ed392.png">
<br><img width="718" alt="a2-extra-alt-5-no-data-for-selected-country-in-selected-period-3" src="https://user-images.githubusercontent.com/90368282/143202812-3e63b1c3-74af-46e3-ab6c-ea5a79a53af0.png">
<br>If there is data available for other selected countries, the chart is then generated with the warned countries excluded. The flow of events return to the end of [Create Chart A](#a2-extra-5-create-chart-a), where the use case ends and the user can re-enter the case.
Otherwise, we head to [No Data for All Selected Countries in Selected Period](#a2-extra-alt-6-no-data-for-all-selected-countries-in-selected-period))].

##### [A2 Extra Alt] 6. No Data for All Selected Countries in Selected Period
This flow may occur after the above, if no data about total cases is available during the whole Period of Interest for all the countries that have been selected.
The system then displays a dialog box informing the user that no data is available for all the selected countries, and asks them to select again. 
<br><img width="718" alt="a2-extra-alt-6-no-data-for-all-selected-countries-in-selected-period-1" src="https://user-images.githubusercontent.com/90368282/143202949-f476af8c-e328-43fa-b426-32ff814944b5.png">
<br><img width="718" alt="a2-extra-alt-6-no-data-for-all-selected-countries-in-selected-period-2" src="https://user-images.githubusercontent.com/90368282/143202956-27da7b46-3b8b-49e2-8e62-13d98105137b.png">
<br><img width="718" alt="a2-extra-alt-6-no-data-for-all-selected-countries-in-selected-period-3" src="https://user-images.githubusercontent.com/90368282/143202962-40c78b8b-1cda-49cc-98c5-ef1d8db97993.png">
<br><img width="718" alt="a2-extra-alt-6-no-data-for-all-selected-countries-in-selected-period-4" src="https://user-images.githubusercontent.com/90368282/143202968-d0c47068-9b64-4c66-b88c-491063c3f5d9.png">
<br>The flow of events return to [Select Countries of Interest](#a2-extra-4-select-countries-of-interest).

## Javadoc
Documentation for the source code of the tasks have been written and generated with Javadoc, with brief descriptions for fields and methods.
You may look at the Javadoc for [the whole project](../master/doc/index.html), or specifically for [Task A1](../master/doc/comp3111/covid/TaskA1.html) and [Task A2](../master/doc/comp3111/covid/TaskA2.html).
