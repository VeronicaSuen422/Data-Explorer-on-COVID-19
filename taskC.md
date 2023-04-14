## Use Case Flow for Task C

### Task C1 (Table C)  
Through Task C1, the user can request and retrieve a data table Table C, which shows the rate of vaccination against COVID-19 by country, on a chosen date, for selected countries, from the given dataset.  

#### Task C1 - Basic Flow
1. Choosing Dataset
2. Enter Table C Tab
3. Select Date of Interest
4. Select Countries of Interest
5. Create Table C
6. Save Table C as Picture (Extra Function)

[Task C1] 1. Choosing Dataset  
The user chooses the dataset to retrieve data from in the Task Zero tab. The default value is the given dataset COVID_Dataset_v1.0.csv.  
![Screenshot 2021-11-28 at 01 31 45](https://user-images.githubusercontent.com/90737034/143691121-33184bab-3e94-456b-84a3-aec28a5ffcb4.png)  

[Task C1] 2. Enter Table C Tab  
The user enters the Table C Tab to initiate Task C1.  
![Screenshot 2021-11-28 at 01 32 42](https://user-images.githubusercontent.com/90737034/143691147-02b4ba0e-9a9e-492e-b713-58c7c0d10760.png)

[Task C1] 3. Select Date of Interest  
The user selects the Date of Interest with the date picker. A list of country will be immediately displayed.  
![Screenshot 2021-11-28 at 01 35 16](https://user-images.githubusercontent.com/90737034/143691202-24916eb2-9767-45de-a9ef-f6c9c208b736.png)

[Task C1] 4. Select Countries of Interest  
The user selects the Countries of Interest from the list. Only countries with vaccination data on that selected date are displayed on the list. At least one country has to be selected in order to proceed to the next step.  
![Screenshot 2021-11-28 at 01 46 32](https://user-images.githubusercontent.com/90737034/143691503-ecff17b6-b504-41dc-800d-aea86b1b028d.png)

[Task C1] 5. Create Table C  
Table C is created automatically after at least one country is selected.  
![Screenshot 2021-11-28 at 01 46 32](https://user-images.githubusercontent.com/90737034/143691503-ecff17b6-b504-41dc-800d-aea86b1b028d.png)

[Task C1] 6. Save Table C as Picture (Extra Function)  
User clicks on Table C. A blue frame is shown around Table C. For MacOS, user presses "control"+"s", while for Windows, user presses "ctrl"+"s". A pop-up is then shown for user to enter the desired directory to save Table C as a picture. After entering the directory, user presses "Save", Table C is saved into the desired location on user's local computer.  
![Screenshot 2021-11-28 at 01 49 56](https://user-images.githubusercontent.com/90737034/143691592-37fe58c2-3e09-43f9-874b-b73bba64bdda.png)  
![Screenshot 2021-11-28 at 01 50 13](https://user-images.githubusercontent.com/90737034/143691596-e2c1a898-0863-426e-8f6a-ffbb252b48dc.png)  
![Screenshot 2021-11-28 at 01 53 51](https://user-images.githubusercontent.com/90737034/143691705-41506523-69da-4304-ad7d-83fce7320609.png)  

The use case ends, and the user can return to steps 1-4 to create another Table C.  

#### Task C1 - Alternative Flow  
The Alternative Flows deal with other situations that may arise when the user interacts with the interface, e.g. input validation.  
1. No Data for Selected Date  
2. No Date Selected  
3. No Country Selected  
4. Select extra countries after 1 country is selected
5. Save Table C as Picture is not needed  
6. Deselect chosen countries/country  
7. Invalid Input of Date

[Task C1 Alt] 1. No Data for Selected Date 
User seclects a date that has not coreesponding vaccination data for each country. No country will then be shown in Step 4 of Basic Flow (Select Countries of Interest) and the users cannot preceeed to create Table C. User can return to Step 3 and re-selects a date.  
![Screenshot 2021-11-28 at 12 25 00](https://user-images.githubusercontent.com/90737034/143729543-e93b0e82-8754-494b-afcc-78c3d6725cf4.png)

[Task C1 Alt]  2. No Date Selected  
User does not select a date from the Date Picker. The flow remains on Step 3 (Select Date of Interest). User can only continue as he/she enters a date.  
![Screenshot 2021-11-28 at 12 36 44](https://user-images.githubusercontent.com/90737034/143729796-7b71324f-30c0-4a03-9c46-f48761847052.png)

[Task C1 Alt] 3. No Country Selected  
User does not select any countries. The flow remains on Step 4 (Select Countries of Interest). User can only continue as he/she enters at least one country.  
![Screenshot 2021-11-28 at 12 39 26](https://user-images.githubusercontent.com/90737034/143729833-0816dfca-fc81-41bb-94c3-019430a8e385.png)  

[Task C1 Alt] 4. Select extra countries after 1 country is selected  
After selecting one country, a table with one country vaccination's information is displayed on the screen autonmatically and immediately. Users can select another country of interest without deselecting the previous country/countries. When user selects another country, the system returns to Step 4 (Select Countries of Interest) and continue to Step 5 (Create Table C) immediately and automatically.  
![Screenshot 2021-11-28 at 12 43 24](https://user-images.githubusercontent.com/90737034/143729927-b9d69caa-129c-4de8-8c04-db849c4d449a.png)  
![Screenshot 2021-11-28 at 18 05 15](https://user-images.githubusercontent.com/90737034/143763600-2ab958b9-3001-458b-8fb1-01b907820f3d.png)  

[Task C1 Alt] 5. Save Table C as Picture is not needed  
After selecting all the counries of interest and creating the coressponding Table C, user does not need to save Table C to somewhere on his/her local computer. The use case ends in Step 5 (Create Table C).  

[Task C1 Alt] 6. Deselect chosen countries/country  
After the user have chosen one or more than one countries and Table C is generated, he/she wants to deselect a selected country. User deselect the country by clicking the box next to the country's name. The system returns to Step 4 (Select Countries of Interest) and proceeds to Step 5 (Create Table C) immediately. The re-generated Table C will then not include the vaccination information of the country deselected.  
![Screenshot 2021-11-28 at 19 00 42](https://user-images.githubusercontent.com/90737034/143765092-f9ba091e-0509-44db-86a2-1930b8a1eff5.png)  
![Screenshot 2021-11-28 at 19 01 06](https://user-images.githubusercontent.com/90737034/143765104-cd5040e9-e054-480c-9710-e6a30128244b.png)  

[Task C1] 7. Invalid Input of Date  
The user enters invalid input of date on Step 3 (Select Date of Interest). The system proceeds to Step 4 after the user enters a valid date using the Date Picker.  
![Screenshot 2021-11-28 at 20 30 17](https://user-images.githubusercontent.com/90737034/143767823-610c37f5-51e3-4075-bb12-20f26dbb22e3.png)  

### Task C2 (Chart C)  
Through Task C2, the user can request and retrieve a data table Table C, which shows the rate of vaccination against COVID-19 by country, on a chosen date, for selected countries, from the given dataset.  

#### Task C2 - Basic Flow  
1. Choosing Dataset  
2. Enter Chart C Tab  
3. Select Starting Date  
4. Select Ending Date  
5. Select Countries of Interest  
6. Create Chart C  
7. Save Chart C as Picture (Extra Function)  

[Task C2] 1. Choosing Dataset  
The user chooses the dataset to retrieve data from in the Task Zero tab. The default value is the given dataset COVID_Dataset_v1.0.csv.  
![Screenshot 2021-11-28 at 01 31 45](https://user-images.githubusercontent.com/90737034/143691121-33184bab-3e94-456b-84a3-aec28a5ffcb4.png)  

[Task C2] 2. Enter Chart C Tab  
The user enters the Table C Tab to initiate Task C2.  
![Screenshot 2021-11-28 at 19 10 06](https://user-images.githubusercontent.com/90737034/143765378-feabdf11-ebe7-418e-818e-c1b2a1b19cfb.png)

[Task C2] 3. Select Starting Date  
The user selects the starting date by date picker.  
![Screenshot 2021-11-28 at 19 41 36](https://user-images.githubusercontent.com/90737034/143766216-dbb26fc0-c98c-4504-b5ee-170df35a6c4b.png)  

[Task C2] 4. Select Ending Date  
The user selects the ending date by date picker.  
![Screenshot 2021-11-28 at 19 46 44](https://user-images.githubusercontent.com/90737034/143766370-c70dc7f0-e9a4-4b57-9b65-0e2dbcf29b03.png)  

[Task C2] 5. Select Countries of Interest  
The user selects the Countries of Interest from the list. Only countries with vaccination data within that selected period are displayed on the list. At least one country has to be selected in order to proceed to the next step.  
![Screenshot 2021-11-28 at 19 48 48](https://user-images.githubusercontent.com/90737034/143766413-6c67febe-862e-4477-b308-61a51291af4d.png)  
![Screenshot 2021-11-28 at 19 49 13](https://user-images.githubusercontent.com/90737034/143766426-2c09c3c3-c8c1-4722-9919-84669e4f5bf2.png)  

[Task C2] 6. Create Chart C  
Chart C is created automatically after at least one country is selected. If a country does not have related vaccination data for some discontinous/countinous days within the selected period, the system will regard the previous latest date with vaccination data as the data for the date without data on that day. If a country does not have any data from the selected starting date to a specific date within the selected period, the curve of that country in Chart C only starts from the first day with vaccination data.  
![Screenshot 2021-11-28 at 19 49 13](https://user-images.githubusercontent.com/90737034/143766426-2c09c3c3-c8c1-4722-9919-84669e4f5bf2.png)  
![Screenshot 2021-11-28 at 20 03 47](https://user-images.githubusercontent.com/90737034/143766885-ea57db15-ffc5-456e-b06c-94a05be762e5.png)  

[Task C2] 7. Save Chart C as Picture (Extra Function)  
User clicks on Chart C. A blue frame is shown around Chart C. For MacOS, user presses "control"+"s", while for Windows, user presses "ctrl"+"s". A pop-up is then shown for user to enter the desired directory to save Chart C as a picture. After entering the directory, user presses "Save", Chart C is saved into the desired location on user's local computer.  
![Screenshot 2021-11-28 at 19 53 34](https://user-images.githubusercontent.com/90737034/143766549-feb29d95-cbbe-472d-bb0d-4aad30aece5b.png)  
![Screenshot 2021-11-28 at 19 54 00](https://user-images.githubusercontent.com/90737034/143766566-7ef78727-b3a5-4a6a-aa37-2833ac8c9a8c.png)  
![Screenshot 2021-11-28 at 19 54 43](https://user-images.githubusercontent.com/90737034/143766583-eacc039b-4da4-4847-86f1-b35d9b02dcf6.png)  

The use case ends, and the user can return to steps 1-5 to create another Chart C.  

#### Task C2 - Alternative Flow  
The Alternative Flows deal with other situations that may arise when the user interacts with the interface, e.g. input validation.  
1. No Start Date Selected  
2. No End Date Selected  
3. Invalid Period of Interest (Ending Date is before the Starting Date)  
4. No Countries Selected  
5. Select extra countries after 1 country is selected
6. Deselect chosen countries/country  
7. Save Table C as Picture is not needed  
8. Invalid Input of Start Date
9. Invalid Input of End Date

[Task C2 Alt] 1. No Start Date Selected  
User does not select a starting date. An error message "No valid input for From Date and To Date" is shown on the console. The user has to select a starting date in order to proceed to Step 5 (Select Countries of Interest).  
![Screenshot 2021-11-28 at 20 11 44](https://user-images.githubusercontent.com/90737034/143767190-0301fa2f-ef2e-4b96-97c3-79bb36292a2a.png)  

[Task C2 Alt] 2. No End Date Selected  
User does not select an ending date. An error message "No valid input for From Date and To Date" is shown on the console. The user has to select an ending date in order to proceed to Step 5 (Select Countries of Interest).  
![Screenshot 2021-11-28 at 20 15 01](https://user-images.githubusercontent.com/90737034/143767297-e38dc018-a37b-41e4-b380-d9b4a4f139e0.png)  

[Task C2 Alt] 3. Invalid Period of Interest (Ending Date is before the Starting Date)  
The selected starting date is after the selected endind date. An error message "No valid input for From Date and To Date" is shown on the console. The user has to re-select an ending date after the starting date in order to proceed to Step 5 (Select Countries of Interest).  
![Screenshot 2021-11-28 at 20 16 22](https://user-images.githubusercontent.com/90737034/143767334-1cbb6832-62c3-47d9-917a-6569804f45a9.png)  

[Task C2 Alt] 4. No Countries Selected  
User does not select any countries. The flow remains on Step 5 (Select Countries of Interest). User can only continue as he/she enters at least one country.  
![Screenshot 2021-11-28 at 20 19 03](https://user-images.githubusercontent.com/90737034/143767424-534d3241-3dfa-4d49-8d72-a280f811325b.png)  

[Task C2 Alt] 5. Select extra countries after 1 country is selected
After selecting one country, a chart with one country vaccination's information is displayed on the screen autonmatically and immediately. Users can select another country of interest without deselecting the previous country/countries. When user selects another country, the system returns to Step 5 (Select Countries of Interest) and continue to Step 6 (Create Chart C) immediately and automatically.  
![Screenshot 2021-11-28 at 20 23 07](https://user-images.githubusercontent.com/90737034/143767579-d9052bcc-960f-45c9-bd95-e0fb44be65e1.png)  
![Screenshot 2021-11-28 at 20 23 38](https://user-images.githubusercontent.com/90737034/143767598-9656d3a6-fc41-4cd8-ba35-1af6a55317e3.png)  
![Screenshot 2021-11-28 at 20 24 11](https://user-images.githubusercontent.com/90737034/143767614-30c14d7f-1203-4a78-b608-03a1bd0940cd.png)  

[Task C2 Alt] 6. Deselect chosen countries/country  
After the user have chosen one or more than one countries and Chart C is generated, he/she wants to deselect a selected country. User deselect the country by clicking the box next to the country's name. The system returns to Step 5 (Select Countries of Interest) and proceeds to Step 6 (Create Chart C) immediately. The re-generated Chart C will then not include the vaccination information of the country deselected.  
![Screenshot 2021-11-28 at 20 26 03](https://user-images.githubusercontent.com/90737034/143767677-f3e919d7-5536-4384-9257-60f372f05bb5.png)  
![Screenshot 2021-11-28 at 20 26 55](https://user-images.githubusercontent.com/90737034/143767703-b6a6b757-24a2-4593-880e-15ef960cfbc5.png)  
![Screenshot 2021-11-28 at 20 27 23](https://user-images.githubusercontent.com/90737034/143767724-d1148e3e-cfb1-4abc-9bfe-9a8bbfcdffd8.png)  

[Task C2 Alt] 7. Save Table C as Picture is not needed  
After selecting all the counries of interest and creating the coressponding Chart C, user does not need to save Chart C to somewhere on his/her local computer. The use case ends in Step 6 (Create Chart C).  

[Task C2 Alt] 8. Invalid Input of Start Date  
The user enters invalid input of starting date on Step 3 (Select Starting Date). The system proceeds to Step 5 after the user enters a valid starting date and a valid ending date using the Date Picker.  
![Screenshot 2021-11-28 at 20 40 03](https://user-images.githubusercontent.com/90737034/143768113-9fcaf0bf-3122-4f81-93f9-c64549bafd8c.png)  
![Screenshot 2021-11-28 at 20 40 49](https://user-images.githubusercontent.com/90737034/143768137-57e210db-2ce0-47a9-9e3a-7ee9f6d69b63.png)  

[Task C2 Alt] 9. Invalid Input of End Date  
The user enters invalid input of ending date on Step 4 (Select Ending Date). The system proceeds to Step 5 after the user enters a valid ending date and a valid starting date using the Date Picker.  
![Screenshot 2021-11-28 at 20 41 16](https://user-images.githubusercontent.com/90737034/143768159-2c327499-3c1d-4a7d-8d89-5a53c136c3a5.png)  
![Screenshot 2021-11-28 at 20 40 49](https://user-images.githubusercontent.com/90737034/143768137-57e210db-2ce0-47a9-9e3a-7ee9f6d69b63.png)  
