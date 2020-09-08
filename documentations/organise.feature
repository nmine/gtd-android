Scenario  create a project from actionItem
Given one actionItem with name 'construire une cabane dans le jardin' is in the actionItems
When I organise my actionsItems
And decide that many actions will be needed
And I create a new project from this actionItem with name 'construire une cabane dans le jardin'
//outcome, traget....
And with a nextAction : 'acheter du bois au brico'
Then a new project 'construire une cabane dans le jardin' is created
And this project has a next action 'acheter du bois au brico'
And the nextActions is added to the defered nextActions at 15/09/2020
And the actionItem 'construire une cabane dans le jardin' is removed from actionItems

Scenario create an nextAction from actionItem
Given one actionItem with name 'appeller christelle' is in the actionItems
When I organise my actionsItems
And I create a new nextACtions from this actionItem with name 'appeller christelle'
Then a new nextActions 'appeller christelle' is created
And the actionItem 'construire une cabane dans le jardin' is removed from actionItems



