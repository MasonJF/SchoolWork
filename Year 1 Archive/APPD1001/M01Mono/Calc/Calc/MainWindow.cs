using System;
using Gtk;

public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();
    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }

    protected void addBtn(object sender, EventArgs e)
    {
        Double num1 = 0;
        Double.TryParse(textbox1.Text, out num1);
        Double num2 = 0;
        Double.TryParse(textbox2.Text, out num2);
        Double answer = num1 + num2;
        textbox3.Text = answer.ToString();
    }

    protected void mtpBtn(object sender, EventArgs e)
    {
        Double num1 = 0;
        Double.TryParse(textbox1.Text, out num1);
        Double num2 = 0;
        Double.TryParse(textbox2.Text, out num2);
        Double answer = num1 * num2;
        textbox3.Text = answer.ToString();
    }

    protected void subBtn(object sender, EventArgs e)
    {
        Double num1 = 0;
        Double.TryParse(textbox1.Text, out num1);
        Double num2 = 0;
        Double.TryParse(textbox2.Text, out num2);
        Double answer = num1 - num2;
        textbox3.Text = answer.ToString();
    }

    protected void divBtn(object sender, EventArgs e)
    {
        Double num1 = 0;
        Double.TryParse(textbox1.Text, out num1);
        Double num2 = 0;
        Double.TryParse(textbox2.Text, out num2);
        Double answer = num1 / num2;
        textbox3.Text = answer.ToString();
    }

    protected void ranBtn(object sender, EventArgs e)
    {
        Random rand = new Random();
        textbox1.Text = rand.Next(1, 100).ToString();
        textbox2.Text = rand.Next(1, 100).ToString();
    }
}
