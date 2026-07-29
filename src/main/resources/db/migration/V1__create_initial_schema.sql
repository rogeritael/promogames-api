CREATE TABLE store (
   id BIGSERIAL PRIMARY KEY,
   name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE game (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    store_id BIGINT NOT NULL,
    platforms TEXT[] NOT NULL,
    image_url TEXT,
    store_url TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_game_store
      FOREIGN KEY (store_id)
          REFERENCES store(id)
);

CREATE TABLE offer (
    id BIGSERIAL PRIMARY KEY,
    game_id UUID NOT NULL,
    original_price NUMERIC(10, 2) NOT NULL,
    current_price NUMERIC(10, 2) NOT NULL,
    starts_at TIMESTAMP,
    ends_at TIMESTAMP,

    CONSTRAINT fk_offer_game
       FOREIGN KEY (game_id)
           REFERENCES game(id),

    CONSTRAINT ck_offer_original_price
       CHECK (original_price >= 0),

    CONSTRAINT ck_offer_current_price
       CHECK (current_price >= 0),

    CONSTRAINT ck_offer_price
       CHECK (current_price <= original_price)
);