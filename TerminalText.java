import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.Window.Hint;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.Arrays;

public class TerminalText {
public static Label lastSave;
public static Label linesLabel;
public static TextBox textBox =  new TextBox("", TextBox.Style.MULTI_LINE);;
public static void main(String[] args) throws IOException {


        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLACK));

        // Create window to hold the panel
        BasicWindow window = new BasicWindow("Terminal Text");
        window.setHints(Arrays.asList(Window.Hint.FULL_SCREEN));

        Panel mainPanel = new Panel();
        mainPanel.setLayoutManager(new BorderLayout());


        // Sets the textbox to be in the center of the screen
        //TextBox textBox = new TextBox("", TextBox.Style.MULTI_LINE);
        textBox.setLayoutData(BorderLayout.Location.CENTER);
        mainPanel.addComponent(textBox);

        // Begin Top Pannel Stuff //
        Panel topPanel = new Panel();
        topPanel.setLayoutData(BorderLayout.Location.TOP);
        topPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));

        // Create buttons
        Button fileButton = new Button("File", new Runnable(){
                                               @Override
                                               public void run(){
                                                       // Actions go here
                                                       // call the list drop down thing
                                                       ActionListDialogs.fileDialog(gui);
                                               }
                                       });
        Button editButton = new Button("Edit", new Runnable(){
                                               @Override
                                               public void run(){
                                                       ActionListDialogs.editDialog(gui);
                                               }
                                       });
        Button viewButton = new Button("View", new Runnable(){
                                               @Override
                                               public void run(){
                                                       ActionListDialogs.viewDialog(gui);
                                               }
                                       });
        Button findButton = new Button("Find", new Runnable(){
                                               @Override
                                               public void run(){
                                                       ActionListDialogs.findDialog(gui);
                                               }
                                       });
        Button packagesileButton = new Button("Packages", new Runnable(){
                                                      @Override
                                                      public void run(){
                                                              ActionListDialogs.packagesDialog(gui);
                                                      }
                                              });
        Button helpButton = new Button("Help", new Runnable(){
                                               @Override
                                               public void run(){
                                                       ActionListDialogs.helpDialog(gui);
                                               }
                                       });



        // add all components for the top Pannel
        topPanel.addComponent(fileButton);
        topPanel.addComponent(editButton);
        topPanel.addComponent(viewButton);
        topPanel.addComponent(findButton);
        topPanel.addComponent(packagesileButton);
        topPanel.addComponent(helpButton);

        mainPanel.addComponent(topPanel.withBorder(Borders.singleLine()));
        // End Top Pannel Stuff //


        Panel leftPanel = new Panel();
        leftPanel.setLayoutData(BorderLayout.Location.LEFT);
        mainPanel.addComponent(leftPanel.withBorder(Borders.singleLine("left")));

        // Begin Bottom Pannel Stuff //
        Panel bottomPanel = new Panel();
        bottomPanel.setLayoutData(BorderLayout.Location.BOTTOM);
        bottomPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));

        linesLabel = new Label("");
        lastSave = new Label("");
        bottomPanel.addComponent(linesLabel);
        bottomPanel.addComponent(lastSave);


        mainPanel.addComponent(bottomPanel.withBorder(Borders.singleLine("")));
        // End Bottom Pannel Stuff //

        window.setComponent(mainPanel);



//start gui
        gui.addWindowAndWait(window);

}
}