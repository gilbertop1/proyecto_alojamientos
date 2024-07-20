document.addEventListener('DOMContentLoaded', function() {
    const calendarElement = document.getElementById('calendar');
    
    function generateCalendar(year, month) {
        const daysInMonth = new Date(year, month + 1, 0).getDate();
        const firstDay = new Date(year, month, 1).getDay();
        
        let html = '<table class="table-calendar">';
        html += '<tr><th>Sun</th><th>Mon</th><th>Tue</th><th>Wed</th><th>Thu</th><th>Fri</th><th>Sat</th></tr><tr>';
        
        // Fill in the empty cells before the first day of the month
        for (let i = 0; i < firstDay; i++) {
            html += '<td></td>';
        }
        
        // Fill in the days of the month
        for (let day = 1; day <= daysInMonth; day++) {
            if ((firstDay + day - 1) % 7 === 0) {
                html += '</tr><tr>';
            }
            html += `<td class="available">${day}</td>`;
        }
        
        // Fill in the remaining cells after the last day of the month
        const lastDay = new Date(year, month, daysInMonth).getDay();
        for (let i = lastDay; i < 6; i++) {
            html += '<td></td>';
        }
        
        html += '</tr></table>';
        calendarElement.innerHTML = html;
    }
    
    const today = new Date();
    generateCalendar(today.getFullYear(), today.getMonth());
});
