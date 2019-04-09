<template>
    <div class="employer-form">
        <div class="container-fluid">
            <h3>Employer Submission Form</h3>
            <form>
                <div class="form-group">
                    <label for="companyName">Company Name</label>
                    <input type="text" class="form-control" id="companyName" placeholder="Enter Company Name..." required>
                </div>
                <div class="form-group">
                    <label for="companyLogo">Company Logo</label>
                    <input type="file" class="form-control-file" id="companyLogo" accept="image/*" required>
                </div>
                <div class="form-group">
                    <label for="companySummary">Company Summary</label>
                    <textarea class="form-control" id="companySummary" rows="7" placeholder="Enter Company Summary..." required></textarea>
                </div>
                <div class="form-group">
                    <label for="numberOfTeams">Number of Teams Attending</label>
                    <input type="number" class="form-control" id="numberOfTeams" placeholder="Enter Number of Teams Attending..." min="1" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</template>