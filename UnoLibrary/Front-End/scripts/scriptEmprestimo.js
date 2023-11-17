function generateDate() {
    const today = new Date(); // Get the current date
    const nextWeek = new Date(today.getTime() + 7 * 24 * 60 * 60 * 1000); // Add 7 days in milliseconds
  
    const data = formatDate(nextWeek);
    console.log(data);
    document.getElementById("data_devolucao").value = data;
}

function formatDate(date) {
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = date.getFullYear();
    return `${day}/${month}/${year}`;
  }