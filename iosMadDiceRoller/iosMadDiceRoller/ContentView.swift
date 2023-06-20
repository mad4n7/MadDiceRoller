import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greet()
    let dice = Dice(numSides: 6)
    @State private var diceImageName = "dice_3"
    @State private var diceImage: Image = Image("dice_3")

	var body: some View {
        diceImage
            .resizable()
            .padding(/*@START_MENU_TOKEN@*/.all, 16.0/*@END_MENU_TOKEN@*/)
            .frame(maxWidth: 200.0, maxHeight: 220.0)
            .scaledToFit()
        Button("Roll!") {
            self.diceImage = getNewImageId(diceRoll: Int(dice.roll()))
//            diceImageName = getNewImageId(dice.roll())
//            if (dice.rollsCount() > 3) {
//
//            }
        }
        .buttonStyle(.borderedProminent)
        .foregroundColor(.white)
        .tint(.purple)
	}
    
    func getNewImageId(diceRoll: Int) -> Image {
        print("Dice number: \(diceRoll)")
        return Image("dice_\(diceRoll)")
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
