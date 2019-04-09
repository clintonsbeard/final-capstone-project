z<template>
    <div class="employer-form">
        <div class="container-fluid">
            <h3>Employer Submission Form</h3>
            <hr>
            <form>
                <div class="form-group">
                    <label for="companyName">Company Name</label>
                    <input type="text" class="form-control" id="companyName" placeholder="Enter Company Name..." required>
                </div>
                <div class="form-group">
                    <label for="companySummary">Company Summary</label>
                    <textarea class="form-control" id="companySummary" rows="3" placeholder="Enter Company Summary..." required></textarea>
                </div>
                <div class="form-group">
                    <label for="daysAttending">Days Attending</label>
                    <input type="date" class="form-control" id="daysAttending" placeholder="Enter Days Attending..." required>
                </div>
                <div class="form-group">
                    <label for="numberOfTeams">Number of Teams Attending</label>
                    <input type="number" class="form-control" id="numberOfTeams" placeholder="Enter Number of Teams Attending..." min="1" required>
                </div>
                <div class="form-group">
                    <label for="restrictions">Additional Appointment Restrictions</label>
                    <textarea class="form-control" id="restrictions" placeholder="Enter Additional Appointment Restrictions..." rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</template>

<script>

</script>