package myproject.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class ActorCrash extends UntypedActor {
	
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("actorSystem");
		
		ActorRef crashRef = system.actorOf(Props.create(ActorCrash.class));
		ActorRef devidingActorRef = system.actorOf(Props.create(DevidingActor.class));
		
		devidingActorRef.tell(5, crashRef);
		devidingActorRef.tell(0, crashRef);
		devidingActorRef.tell(1, crashRef);
	}

	@Override
	public void onReceive(Object message) throws Exception {
		System.out.printf("Received result: [%s]%n", message);
	}

}
