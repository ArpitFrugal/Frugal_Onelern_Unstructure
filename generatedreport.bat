set /p id=Enter date: 
allure generate ../Frugal_Onelern/allure-results %id%
git add %id%
git commit -m "%id%"
git push
