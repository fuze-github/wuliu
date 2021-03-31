import { observable,action,computed} from "mobx";

class Appstore {
    @observable x1 = "123"
    @observable x2 = ""
    @observable x3 = ""
    @observable x4 = ""
    @action change(){

    }
    @action add(){

    }
    @computed get num(){
        return <input/>
    }
}
const stroe = new Appstore

export default stroe